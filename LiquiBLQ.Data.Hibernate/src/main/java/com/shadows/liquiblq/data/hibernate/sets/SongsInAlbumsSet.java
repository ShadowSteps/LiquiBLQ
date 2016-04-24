/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Albums;
import com.shadows.liquiblq.data.hibernate.entities.Songs;
import com.shadows.liquiblq.data.hibernate.entities.SongsInAlbums;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.SongInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.data.SongInAlbumData;
import com.shadows.liquiblq.data.interfaces.sets.ISongsInAlbumsSet;
import java.util.List;
import java.util.UUID;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author John
 */
public class SongsInAlbumsSet extends BaseSet<SongsInAlbums, SongInAlbum> implements ISongsInAlbumsSet{

    @Override
    protected SongInAlbum ConvertEntityToDTO(SongsInAlbums entity) {
        SongInAlbum artistInAlbum = new SongInAlbum();
        artistInAlbum.Album = entity.getAlbum().getId();
        artistInAlbum.Song = entity.getSong().getId();
        artistInAlbum.Id = entity.getId();
        return artistInAlbum;
    }

    @Override
    public Integer Add(SongInAlbumData Data) throws Exception {
        Session session = factory.openSession();        
        session.beginTransaction();
        Integer Id;
        try {               
            List<Songs> songsList = session
                    .createCriteria(Songs.class)
                    .add(Restrictions.eq("id", Data.Song))
                    .list();
            if (songsList.isEmpty())
                throw new EntityCannotBeFoundException("Song not found!");
            Songs song = songsList.get(0);        
            List<Albums> albumsList = session
                    .createCriteria(Albums.class)
                    .add(Restrictions.eq("id", Data.Album))
                    .list();
            if (albumsList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = albumsList.get(0);        
            SongsInAlbums songInAlbum = new SongsInAlbums();
            songInAlbum.setAlbum(album);
            songInAlbum.setSong(song);
            Id = (Integer)session.save(songInAlbum);
            session.getTransaction().commit();
        }
        catch(HibernateException | EntityCannotBeFoundException exp){
            session.getTransaction().rollback();
            throw new EntityCannotByCreatedException("Could not save SongInAlbum data! See inner exception!", exp);
        }
        finally {
            session.close();
        }
        return Id;
    }

    @Override
    public void Edit(Integer Key, SongInAlbumData Data) throws Exception {
        Session session = factory.openSession();        
        session.beginTransaction();
        Criteria cr = session.createCriteria(SongsInAlbums.class);
        cr.add(Restrictions.eq("id", Key));
        try {           
            List<SongsInAlbums> artistsInAlbumsList = cr.list();
            if (artistsInAlbumsList.isEmpty())
                throw new EntityCannotBeFoundException("SongInAlbum not found!");
            SongsInAlbums songInAlbum = artistsInAlbumsList.get(0);
            List<Songs> songsList = session
                    .createCriteria(Songs.class)
                    .add(Restrictions.eq("id", Data.Song))
                    .list();
            if (songsList.isEmpty())
                throw new EntityCannotBeFoundException("Song not found!");
            Songs song = songsList.get(0);   
            List<Albums> albumsList = session
                    .createCriteria(Albums.class)
                    .add(Restrictions.eq("id", Data.Album))
                    .list();
            if (albumsList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = albumsList.get(0);                    
            songInAlbum.setAlbum(album);
            songInAlbum.setSong(song);
            session.update(songInAlbum);
            session.getTransaction().commit();
        }
        catch(HibernateException | EntityCannotBeFoundException exp){
            session.getTransaction().rollback();
            throw new EntityCannotByCreatedException("Could not save SongInAlbum data! See inner exception!", exp);
        }
        finally {
            session.close();
        }
    }

    @Override
    public void Delete(Integer Key) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(SongsInAlbums.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<SongsInAlbums> songsInAlbumList = cr.list();
            if (songsInAlbumList.isEmpty())
                throw new EntityCannotBeFoundException("SongsInAlbums not found!");
            SongsInAlbums songInAlbum = songsInAlbumList.get(0);            
            session.delete(songInAlbum);
            session.getTransaction().commit();
        }
        catch(HibernateException exp){
            session.getTransaction().rollback();
            throw new EntityCannotBeDeletedException("SongsInAlbums could not be deleted! See inner exception!",exp);
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<SongInAlbum> GetAll() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(SongsInAlbums.class);
        List<SongInAlbum> SongInAlbumDTOs;
        try {
            List<SongsInAlbums> SongInAlbumList = cr.list();
            SongInAlbumDTOs = ConvertEntityArrayToDTOArray(SongInAlbumList);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return SongInAlbumDTOs;
    }

    @Override
    public SongInAlbum GetById(Integer Id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(SongsInAlbums.class);
        cr.add(Restrictions.eq("id", Id));
        SongInAlbum DTO;
        try {
            List<SongsInAlbums> SongInAlbumList = cr.list();
            if (SongInAlbumList.isEmpty())
                throw new EntityCannotBeFoundException("SongsInAlbums not found!");
            SongsInAlbums songsInAlbum = SongInAlbumList.get(0);            
            DTO = ConvertEntityToDTO(songsInAlbum);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return DTO;
    }

    @Override
    public List<SongInAlbum> GetBySongId(UUID Id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(SongsInAlbums.class);
        cr.add(Restrictions.eq("song.id",Id));
        List<SongInAlbum> SongInAlbumDTOs;
        try {
            List<SongsInAlbums> SongInAlbumList = cr.list();
            SongInAlbumDTOs = ConvertEntityArrayToDTOArray(SongInAlbumList);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return SongInAlbumDTOs;
    }

    @Override
    public List<SongInAlbum> GetByAlbumId(UUID Id) {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(SongsInAlbums.class);
        cr.add(Restrictions.eq("album.id",Id));
        List<SongInAlbum> SongInAlbumDTOs;
        try {
            List<SongsInAlbums> SongInAlbumList = cr.list();
            SongInAlbumDTOs = ConvertEntityArrayToDTOArray(SongInAlbumList);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return SongInAlbumDTOs;
    }
    
}
