/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Artists;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeEditedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistData;
import com.shadows.liquiblq.data.interfaces.sets.IArtistsSet;
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
public class ArtistsSet extends BaseSet<Artists, Artist> implements IArtistsSet{

    @Override
    protected Artist ConvertEntityToDTO(Artists entity) {
        Artist artist = new Artist();
        artist.Name = entity.getName();
        artist.Id = entity.getId();
        artist.DateOfBirth = entity.getDateofbirth();
        artist.Nickname = entity.getNickname();
        return artist;
    }

    @Override
    public List<Artist> GetAll() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Artists.class);
        List<Artist> ArtistDTOs;
        try {
            List<Artists> ArtistList = cr.list();
            ArtistDTOs = ConvertEntityArrayToDTOArray(ArtistList);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return ArtistDTOs;
    }

    @Override
    public Artist GetById(UUID Id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Artists.class);
        cr.add(Restrictions.eq("id", Id));
        Artist DTO;
        try {
            List<Artists> ArtistList = cr.list();
            if (ArtistList.isEmpty())
                throw new EntityCannotBeFoundException("Artist not found!");
            Artists artist = ArtistList.get(0);            
            DTO = ConvertEntityToDTO(artist);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return DTO;
    }

    @Override
    public UUID Add(ArtistData Data) throws Exception {
        Artists artists = new Artists();
        artists.setDateofbirth(Data.DateOfBirth);
        artists.setName(Data.Name);
        artists.setNickname(Data.Nickname);
        UUID Id;
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Id = (UUID)session.save(artists);
            session.getTransaction().commit();
        }
        catch(Exception exp){
            session.getTransaction().rollback();
            throw new EntityCannotByCreatedException("Could not save Artist data! See inner exception!", exp);
        }
        finally {
            session.close();
        }
        return Id;
    }

    @Override
    public void Edit(UUID Key, ArtistData Data) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Artists.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Artists> AlbumList = cr.list();
            if (AlbumList.isEmpty())
                throw new EntityCannotBeFoundException("Artist not found!");
            Artists artists = AlbumList.get(0);            
            artists.setDateofbirth(Data.DateOfBirth);
            artists.setName(Data.Name);
            artists.setNickname(Data.Nickname);
            session.update(artists);
            session.getTransaction().commit();
        }
        catch(HibernateException exp){
            session.getTransaction().rollback();
            throw new EntityCannotBeEditedException("Artist could not be updated! See inner exception!",exp);
        }
        finally{
            session.close();
        }
    }

    @Override
    public void Delete(UUID Key) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Artists.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Artists> ArtistsList = cr.list();
            if (ArtistsList.isEmpty())
                throw new EntityCannotBeFoundException("Artists not found!");
            Artists artist = ArtistsList.get(0);            
            session.delete(artist);
            session.getTransaction().commit();
        }
        catch(HibernateException exp){
            session.getTransaction().rollback();
            throw new EntityCannotBeDeletedException("Artists could not be deleted! See inner exception!",exp);
        }
        finally{
            session.close();
        }
    }
    
}
