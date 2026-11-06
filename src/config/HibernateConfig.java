package config;

import model.Pokedex;
import model.Adestrador;
import model.Pokemon;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfig {

    private static final SessionFactory sessionFactory;

    static {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder().configure("resources/properties.xml").build();
        try {
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
            metadataSources.addAnnotatedClass(Pokedex.class);
            metadataSources.addAnnotatedClass(Adestrador.class);
            metadataSources.addAnnotatedClass(Pokemon.class);

            Metadata metadata = metadataSources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}