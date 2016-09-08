package configuration;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

public class HibernateConfiguration {
    private static HibernateConfiguration hibernateConfig = null;
    private static AnnotationConfiguration configuration = null;
    SessionFactory sessionFactory = null;

    private HibernateConfiguration() {
    
    }

    public static HibernateConfiguration getConnect() {
        try {
            if(null == hibernateConfig) {
                hibernateConfig = new HibernateConfiguration();
            }
        } catch(HibernateException e) {
            System.out.println("Connection lost");
        }
        return hibernateConfig;
    }
   
    public AnnotationConfiguration createConfiguration() {
        try {
            if(null == configuration) {
                configuration = new AnnotationConfiguration();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(model.User.class);
                configuration.addAnnotatedClass(model.Address.class);
                configuration.addAnnotatedClass(model.Advertisement.class);
                configuration.addAnnotatedClass(model.Review.class);
                configuration.addAnnotatedClass(model.Role.class);
                configuration.addAnnotatedClass(model.Facility.class);
            }
        } catch(HibernateException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        return configuration;
    }
    
    public SessionFactory createSessionFactory() {
        try {
            if(null == sessionFactory) {
                sessionFactory = createConfiguration().buildSessionFactory();
            }
        } catch(HibernateException e) {
            System.out.println("Connection destroyed");
            e.printStackTrace();
        }
        return sessionFactory;
    }    
}

