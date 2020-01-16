package com;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory buildSessionFactory(String host, int port, String db, String user, String pass) {
        try {
        	AnnotationConfiguration config = new AnnotationConfiguration();
        	Configuration c = config.configure();
        	String jdbcUrl = "jdbc:oracle:thin:@" + host + ":" + port + "/" + db;
        	c.setProperty("hibernate.connection.url", jdbcUrl);
        	c.setProperty("hibernate.connection.username", user);
        	c.setProperty("hibernate.connection.password", pass);
        	
        	return config.configure().buildSessionFactory();
        	
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void shutdown(SessionFactory sf) {
    	sf.close();
    }
}
