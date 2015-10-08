/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.utils;

import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import java.net.URL;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author John
 */
public class SessionFactoryContainer {
    private static SessionFactory factory;
    private static void CreateFactory() throws SessionFactoryConfigurationException{
        if (factory == null){
            try {
                factory = new Configuration().configure().buildSessionFactory();
            }
            catch (Exception e) {                
                throw new SessionFactoryConfigurationException("Could not create factory! Inner exception message: "+e.getMessage());
            }
        }
    }
    public static SessionFactory getFactory() throws SessionFactoryConfigurationException{
        CreateFactory();
        return factory;
    }
}
