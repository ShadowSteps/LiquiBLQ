/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Albums;
import com.shadows.liquiblq.data.hibernate.entities.Artists;
import com.shadows.liquiblq.data.hibernate.entities.ArtistsInAlbums;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.ArtistInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistInAlbumData;
import com.shadows.liquiblq.data.interfaces.sets.IArtistsInAlbumsSet;
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
public class ArtistsInAlbumsSet extends BaseSet<ArtistsInAlbums, ArtistInAlbum> implements IArtistsInAlbumsSet{

    @Override
    protected ArtistInAlbum ConvertEntityToDTO(ArtistsInAlbums entity) {
        ArtistInAlbum artistInAlbum = new ArtistInAlbum();
        artistInAlbum.Album = entity.getAlbum().getId();
        artistInAlbum.Artist = entity.getArtist().getId();
        artistInAlbum.Id = entity.getId();
        return artistInAlbum;
    }

    @Override
    public Integer Add(ArtistInAlbumData Data) throws Exception {
        Session session = factory.openSession();        
        Integer Id;
        try {               
            List<Artists> artistsList = session
                    .createCriteria(Artists.class)
                    .add(Restrictions.eq("id", Data.Artist))
                    .list();
            if (artistsList.isEmpty())
                throw new EntityCannotBeFoundException("Artist not found!");
            Artists artist = artistsList.get(0);        
            List<Albums> albumsList = session
                    .createCriteria(Albums.class)
                    .add(Restrictions.eq("id", Data.Album))
                    .list();
            if (albumsList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = albumsList.get(0);        
            ArtistsInAlbums artistInAlbum = new ArtistsInAlbums();
            artistInAlbum.setAlbum(album);
            artistInAlbum.setArtist(artist);
            Id = (Integer)session.save(artistInAlbum);
        }
        catch(HibernateException | EntityCannotBeFoundException exp){
            throw new EntityCannotByCreatedException("Could not save ArtistInAlbum data! See inner exception!", exp);
        }
        finally {
            session.close();
        }
        return Id;
    }

    @Override
    public void Edit(Integer Key, ArtistInAlbumData Data) throws Exception {
        Session session = factory.openSession();        
        Criteria cr = session.createCriteria(ArtistsInAlbums.class);
        cr.add(Restrictions.eq("id", Key));
        try {           
            List<ArtistsInAlbums> artistsInAlbumsList = cr.list();
            if (artistsInAlbumsList.isEmpty())
                throw new EntityCannotBeFoundException("ArtistInAlbum not found!");
            ArtistsInAlbums artistInAlbum = artistsInAlbumsList.get(0);
            List<Artists> artistsList = session
                    .createCriteria(Artists.class)
                    .add(Restrictions.eq("id", Data.Artist))
                    .list();
            if (artistsList.isEmpty())
                throw new EntityCannotBeFoundException("Artist not found!");
            Artists artist = artistsList.get(0);        
            List<Albums> albumsList = session
                    .createCriteria(Albums.class)
                    .add(Restrictions.eq("id", Data.Album))
                    .list();
            if (albumsList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = albumsList.get(0);                    
            artistInAlbum.setAlbum(album);
            artistInAlbum.setArtist(artist);
            session.update(artistInAlbum);
        }
        catch(HibernateException | EntityCannotBeFoundException exp){
            throw new EntityCannotByCreatedException("Could not save ArtistInAlbum data! See inner exception!", exp);
        }
        finally {
            session.close();
        }
    }

    @Override
    public void Delete(Integer Key) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(ArtistsInAlbums.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<ArtistsInAlbums> artistsInAlbumList = cr.list();
            if (artistsInAlbumList.isEmpty())
                throw new EntityCannotBeFoundException("ArtistsInAlbums not found!");
            ArtistsInAlbums artistsInAlbum = artistsInAlbumList.get(0);            
            session.delete(artistsInAlbum);
        }
        catch(HibernateException exp){
            throw new EntityCannotBeDeletedException("ArtistsInAlbums could not be deleted! See inner exception!",exp);
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<ArtistInAlbum> GetAll() throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(ArtistsInAlbums.class);
        List<ArtistInAlbum> ArtistInAlbumDTOs;
        try {
            List<ArtistsInAlbums> ArtistInAlbumList = cr.list();
            ArtistInAlbumDTOs = ConvertEntityArrayToDTOArray(ArtistInAlbumList);
        }
        finally{
            session.close();
        }
        return ArtistInAlbumDTOs;
    }

    @Override
    public ArtistInAlbum GetById(Integer Id) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(ArtistInAlbum.class);
        cr.add(Restrictions.eq("id", Id));
        ArtistInAlbum DTO;
        try {
            List<ArtistsInAlbums> ArtistInAlbumList = cr.list();
            if (ArtistInAlbumList.isEmpty())
                throw new EntityCannotBeFoundException("ArtistsInAlbums not found!");
            ArtistsInAlbums artistsInAlbums = ArtistInAlbumList.get(0);            
            DTO = ConvertEntityToDTO(artistsInAlbums);
        }
        finally{
            session.close();
        }
        return DTO;
    }

    @Override
    public List<ArtistInAlbum> GetByAlbumId(UUID Id) {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(ArtistsInAlbums.class);
        cr.add(Restrictions.eq("album", Id));
        List<ArtistInAlbum> ArtistInAlbumDTOs;
        try {
            List<ArtistsInAlbums> ArtistInAlbumList = cr.list();
            ArtistInAlbumDTOs = ConvertEntityArrayToDTOArray(ArtistInAlbumList);
        }
        finally{
            session.close();
        }
        return ArtistInAlbumDTOs;
    }

    @Override
    public List<ArtistInAlbum> GetByArtistId(UUID Id) {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(ArtistsInAlbums.class);
        cr.add(Restrictions.eq("artist", Id));
        List<ArtistInAlbum> ArtistInAlbumDTOs;
        try {
            List<ArtistsInAlbums> ArtistInAlbumList = cr.list();
            ArtistInAlbumDTOs = ConvertEntityArrayToDTOArray(ArtistInAlbumList);
        }
        finally{
            session.close();
        }
        return ArtistInAlbumDTOs;
    }
    
}
