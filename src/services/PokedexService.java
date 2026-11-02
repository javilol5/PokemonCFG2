package services;


import config.HibernateConfig;
import model.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.*;
import java.util.List;

public class PokedexService {

    //CREATE
    public void create(int id, String nome, double peso, String misc) {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokedex px = new Pokedex();

            px.setId((long) id);
            px.setNome(nome);
            px.setPeso(peso);
            px.setMisc(misc);

            session.save(px);
            transaction.commit();
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    //READ
    public void read() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            List<Pokedex> listaPokedex = session.createQuery("FROM Pokedex", Pokedex.class).list();

            for (Pokedex px : listaPokedex) {
                System.out.println("ID: " + px.getId() +
                        ", Nombre: " + px.getNome() +
                        ", Peso: " + px.getPeso() +
                        ", Misc: " + px.getMisc());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //UPDATE
    public void update(int id, String nome, double peso, String misc) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            Pokedex px = session.get(Pokedex.class, (long) id);

            if (px != null) {
                px.setNome(nome);
                px.setPeso(peso);
                px.setMisc(misc);

                session.update(px);
            }

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE
    public void delete() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.createQuery("DELETE FROM Pokedex").executeUpdate();

            transaction.commit();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // TO XML
    public void toXML() {

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {

            List<Pokedex> lista = session.createQuery("FROM Pokedex", Pokedex.class).list();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.newDocument();

            Element raiz = documento.createElement("pokemons");
            documento.appendChild(raiz);

            for (Pokedex px : lista) {

                Element pokemon = documento.createElement("pokemon");

                Element id = documento.createElement("id");
                id.setTextContent(String.valueOf(px.getId()));

                Element nome = documento.createElement("nome");
                nome.setTextContent(px.getNome());

                Element peso = documento.createElement("peso");
                peso.setTextContent(String.valueOf(px.getPeso()));

                Element misc = documento.createElement("misc");
                misc.setTextContent(px.getMisc());

                pokemon.appendChild(id);
                pokemon.appendChild(nome);
                pokemon.appendChild(peso);
                pokemon.appendChild(misc);

                raiz.appendChild(pokemon);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("pokemons.xml"));

            transformer.transform(source, result);

            System.out.println("XML de pokemons creado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}