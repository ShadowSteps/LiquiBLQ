/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories;

import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.ArtistsInAlbums;
import com.shadows.liquiblq.data.entitys.Songs;
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
 * @author toshiba
 */
public class SongsRepository {
    public static List<Songs> GetAllSongs() throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession(); 
            try{
                session.beginTransaction();
                Criteria cr = session.createCriteria(Songs.class);     
                List<Songs> Songs = cr.list();                
                session.getTransaction().commit();
                return Songs;
            }catch(HibernateException e){
                session.getTransaction().rollback();
                throw e;
            }finally{
                 session.disconnect();
            }
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("Songs cannot be fetched! Inner exception message: "+ex.getMessage());
        }
    }
    public static Songs GetSongById(UUID id) throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession(); 
            try{
                session.beginTransaction();
                Criteria cr = session.createCriteria(Songs.class);     
                cr.add(Restrictions.eq("id", id));
                List<Songs> ListSongs = cr.list();
                if (ListSongs.isEmpty()){
                    throw new EntityCannotBeFoundException("Song was not found!");
                }                
                session.getTransaction().commit();
                return ListSongs.get(0);
            }catch(HibernateException e){
                session.getTransaction().rollback();
                throw e;
            }finally{
                 session.disconnect();
            }
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("Songs cannot be fetched! Inner exception message: "+ex.getMessage());
        }
    }
    public static List<Songs> GetSongsForAlbum(Album album) throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession(); 
            try{
                session.beginTransaction();
                Criteria crAlbumInArtists = session.createCriteria(SongsInAlbum.class); 
                crAlbumInArtists.add(Restrictions.eq("album", album));
                List<SongsInAlbum> SongsInAlbumsList = crAlbumInArtists.list();
                List<Songs> AList = new ArrayList<Songs>();
                for (SongsInAlbum ArtistInAlbum : SongsInAlbumsList) {
                    AList.add(ArtistInAlbum.getSongs());
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
}
