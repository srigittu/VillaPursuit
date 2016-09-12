// Copyright (C) 2015 Ideas2IT, Inc.
// All rights reserved

package com.i2i.villapursuit.connection;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * <p>
 * Singleton class which establishes connection for database.
 * </p>
 * 
 * @author Team #3
 * 
 * @created 07/09/16
 *
 */

public class HibernateConnection {
    private static SessionFactory sessionFactory = null;
    
    private static SessionFactory createInstance() {
        try {
            return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error in Session Factory Creation:"+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
                sessionFactory = createInstance();
        }
        return sessionFactory;
    }
}
