package utils;

import models.Group;
import models.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Student.class);

                sessionFactory = configuration.buildSessionFactory();
//                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySetting(configuration.getProperties(), "jdbc");
//                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}

