/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.utils;

import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author John
 */
public class SessionFactoryContainer {
    private static SessionFactory factory;
    private static void CreateFactory() throws SessionFactoryConfigurationException{
        if (factory == null){
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() 
                    .build();
            try {
                factory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                StandardServiceRegistryBuilder.destroy( registry );
                throw new SessionFactoryConfigurationException("Could not create factory!Inner exception message: "+e.getMessage());
            }
        }
    }
    public static SessionFactory getFactory() throws SessionFactoryConfigurationException{
        CreateFactory();
        return factory;
    }
}
