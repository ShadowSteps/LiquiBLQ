/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories;

import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.utils.SessionFactoryContainer;
import java.util.List;
import java.util.UUID;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author mihail
 */
public class AlbumsRepository {
    
    public static List<Album> GetAllAlbums() throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession(); 
            try{
                session.beginTransaction();
                Criteria cr = session.createCriteria(Album.class);     
                List<Album> Albums = cr.list();                
                session.getTransaction().commit();
                return Albums;
            }catch(HibernateException e){
                session.getTransaction().rollback();
                throw e;
            }finally{
                 session.disconnect();
            }
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("Albums cannot be fetched! Inner exception message: "+ex.getMessage());
        }
    }
    public static Album GetAlbumById(UUID id) throws EntityCannotBeFoundException {
        try{
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            Album results = null;
            try {                
                session.beginTransaction();
                Criteria cr = session.createCriteria(Album.class);     
                cr.add(Restrictions.eq("id", id));
                List ListUsers = cr.list();
                if (ListUsers.isEmpty()){
                    throw new EntityCannotBeFoundException("Album was not found!");
                }
                results = (Album)ListUsers.get(0);            
                session.getTransaction().commit();      
                return results;
            }
            catch(HibernateException Exp){
                session.getTransaction().rollback();
                throw new EntityCannotBeFoundException("Album was not found! Inner Exception: "+Exp.getMessage());
            }
            finally {
                session.disconnect();
            }  
        }catch(Exception ex){
            throw new EntityCannotBeFoundException("Album was not found! Inner exception message: "+ex.getMessage());
        }
    }
    
}
