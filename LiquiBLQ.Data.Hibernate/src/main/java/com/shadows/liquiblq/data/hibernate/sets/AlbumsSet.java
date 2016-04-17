/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Albums;
import com.shadows.liquiblq.data.hibernate.entities.Users;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeEditedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.data.AlbumData;
import com.shadows.liquiblq.data.interfaces.sets.IAlbumsSet;
import java.time.Instant;
import java.util.Date;
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
public class AlbumsSet extends BaseSet<Albums,Album> implements IAlbumsSet {

    @Override
    public UUID Add(AlbumData Data) throws EntityCannotByCreatedException {
        Albums albums = new Albums();
        albums.setDate(Data.PublishDate);
        albums.setName(Data.Name);
        UUID Id;
        Session session = factory.openSession();
        try {
            Id = (UUID)session.save(albums);
        }
        catch(Exception exp){
            throw new EntityCannotByCreatedException("Could not save Album data! See inner exception!", exp);
        }
        finally {
            session.close();
        }
        return Id;
    }

    @Override
    public void Edit(UUID Key,AlbumData Data) throws EntityCannotBeFoundException, EntityCannotBeEditedException {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Albums.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Albums> AlbumList = cr.list();
            if (AlbumList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = AlbumList.get(0);            
            album.setDate(Data.PublishDate);
            album.setName(Data.Name);
            session.update(album);
        }
        catch(HibernateException exp){
            throw new EntityCannotBeEditedException("Album could not be updated! See inner exception!",exp);
        }
        finally{
            session.close();
        }
    }

    @Override
    public void Delete(UUID Key) throws EntityCannotBeFoundException, EntityCannotBeDeletedException {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Albums.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Albums> AlbumList = cr.list();
            if (AlbumList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = AlbumList.get(0);            
            session.delete(album);
        }
        catch(HibernateException exp){
            throw new EntityCannotBeDeletedException("Album could not be deleted! See inner exception!",exp);
        }
        finally{
            session.close();
        }
    }

    @Override
    public List<Album> GetAll() {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Albums.class);
        List<Album> AlbumDTOs;
        try {
            List<Albums> AlbumList = cr.list();
            AlbumDTOs = ConvertEntityArrayToDTOArray(AlbumList);
        }
        finally{
            session.close();
        }
        return AlbumDTOs;
    }

    @Override
    public Album GetById(UUID Id) throws EntityCannotBeFoundException {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Albums.class);
        cr.add(Restrictions.eq("id", Id));
        Album DTO;
        try {
            List<Albums> AlbumList = cr.list();
            if (AlbumList.isEmpty())
                throw new EntityCannotBeFoundException("Album not found!");
            Albums album = AlbumList.get(0);            
            DTO = ConvertEntityToDTO(album);
        }
        finally{
            session.close();
        }
        return DTO;
    }
    
    @Override
    protected Album ConvertEntityToDTO(Albums entity) {
        Album album = new Album();
        album.Name = entity.getName();
        album.Id = entity.getId();
        album.PublishDate = entity.getDate();
        return album;
    }
    
}
