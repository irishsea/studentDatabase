package utils;

import models.Group;
import models.Role;
import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    public static Session getCurrentSession() {
        Map<String, String> settings = new HashMap<>();

        settings.put("connection.driver_class", "org.postgresql.Driver");
        settings.put("dialect", "org.hibernate.dialect.SQLServerDialect");
        settings.put("hibernate.connection.url",
                "jdbc:postgresql://localhost:5432/studentDatabase");
        settings.put("hibernate.connection.username", "postgres");
        settings.put("hibernate.connection.password", "4853");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        /**
         * check annotated classes!
         */

        metadataSources.addAnnotatedClass(Student.class);
        metadataSources.addAnnotatedClass(Group.class);
        metadataSources.addAnnotatedClass(Role.class);

        Metadata metadata = metadataSources.buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory.getCurrentSession();
    }
}
