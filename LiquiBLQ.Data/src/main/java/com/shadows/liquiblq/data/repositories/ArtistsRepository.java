/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories;

import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.ArtistsInAlbums;
import com.shadows.liquiblq.data.entitys.SongsInAlbum;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.utils.SessionFactoryContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
public class ArtistsRepository {
    
    public static List<Artist> GetArtistsForAlbum(Album album) throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession(); 
            try{
                session.beginTransaction();
                Criteria crAlbumInArtists = session.createCriteria(ArtistsInAlbums.class); 
                crAlbumInArtists.add(Restrictions.eq("album", album));
                List<ArtistsInAlbums> SongsInAlbumsList = crAlbumInArtists.list();
                List<Artist> AList = new ArrayList<Artist>();
                for (ArtistsInAlbums ArtistInAlbum : SongsInAlbumsList) {
                    AList.add(ArtistInAlbum.getArtist());
                }                           
                session.getTransaction().commit();
                return AList;
            }catch(HibernateException e){
                session.getTransaction().rollback();
                throw e;
            }finally{
                 session.disconnect();
            }
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("Artists could not be loaded! "+ex.getMessage());
        }
    }
    public static List<Artist> GetAllArtists() throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession(); 
            try{
                session.beginTransaction();
                Criteria cr = session.createCriteria(Artist.class);     
                List<Artist> Artists = cr.list();                
                session.getTransaction().commit();
                return Artists;
            }catch(HibernateException e){
                session.getTransaction().rollback();
                throw e;
            }finally{
                 session.disconnect();
            }
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("Artists could not be loaded! "+ex.getMessage());
        }
    }

  
    public static Artist GetArtistById(UUID id) throws EntityCannotBeFoundException {
        try{
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            Artist results;
            try {                
                session.beginTransaction();
                Criteria cr = session.createCriteria(Artist.class);     
                cr.add(Restrictions.eq("id", id));
                List ListArtist = cr.list();
                if (ListArtist.isEmpty()){
                    throw new EntityCannotBeFoundException("Artist was not found!");
                }
                results = (Artist)ListArtist.get(0);            
                session.getTransaction().commit();      
                return results;
            }
            catch(HibernateException Exp){
                session.getTransaction().rollback();
                throw new EntityCannotBeFoundException("Artist was not found! Inner Exception: "+Exp.getMessage());
            }
            finally {
                session.disconnect();
            }  
        }catch(SessionFactoryConfigurationException | HibernateException | EntityCannotBeFoundException ex){
            throw new EntityCannotBeFoundException("Artist was not found! Inner exception message: "+ex.getMessage());
        }
    }
}
