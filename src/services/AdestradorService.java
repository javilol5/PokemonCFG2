package services;

import config.HibernateConfig;
import model.Adestrador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.*;
import java.time.LocalDate;
import java.util.List;

public class AdestradorService {

    // CREATE
    public void create(String nome, LocalDate nacemento) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Adestrador ad = new Adestrador(nome, nacemento);

            session.save(ad);

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ
    public void read() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Adestrador> lista = session.createQuery("FROM Adestrador", Adestrador.class).list();

            for (Adestrador ad : lista) {
                System.out.println(ad);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // UPDATE
    public void update(int id, String nome, LocalDate nacemento) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Adestrador ad = session.get(Adestrador.class, id);

            if (ad != null) {
                ad.setNome(nome);
                ad.setNacemento(nacemento);

                session.update(ad);
            }

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // TO XML
    public void toXML() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Adestrador> lista = session.createQuery("FROM Adestrador", Adestrador.class).list();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.newDocument();

            Element raiz = documento.createElement("adestradores");
            documento.appendChild(raiz);

            for (Adestrador ad : lista) {

                Element adestrador = documento.createElement("adestrador");

                Element id = documento.createElement("id");
                id.setTextContent(String.valueOf(ad.getId()));

                Element nome = documento.createElement("nome");
                nome.setTextContent(ad.getNome());

                Element nacemento = documento.createElement("nacemento");
                nacemento.setTextContent(ad.getNacemento().toString());

                adestrador.appendChild(id);
                adestrador.appendChild(nome);
                adestrador.appendChild(nacemento);

                raiz.appendChild(adestrador);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("adestradores.xml"));

            transformer.transform(source, result);

            System.out.println("XML de adestradores creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    public void delete() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.createQuery("DELETE FROM Adestrador").executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}