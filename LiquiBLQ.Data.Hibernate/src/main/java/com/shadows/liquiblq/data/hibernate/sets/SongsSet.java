package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Songs;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeEditedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import com.shadows.liquiblq.data.interfaces.dto.data.SongData;
import com.shadows.liquiblq.data.interfaces.sets.ISongsSet;
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
public class SongsSet extends BaseSet<Songs, Song> implements ISongsSet {
    
    @Override
    protected Song ConvertEntityToDTO(Songs entity) {
        Song dto = new Song();
        dto.Genre = entity.getGenre();
        dto.Id = entity.getId();
        dto.Name = entity.getName();
        dto.PublishDate = entity.getDate();
        return dto;
    }
    
    @Override
    public List<Song> GetAll() throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Songs.class);
        List<Song> DTOs;
        try {
            List<Songs> List = cr.list();
            DTOs = ConvertEntityArrayToDTOArray(List);
        } finally {
            session.close();
        }
        return DTOs;
    }
    
    @Override
    public Song GetById(UUID Id) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Songs.class);
        cr.add(Restrictions.eq("id", Id));
        Song DTO;
        try {
            List<Songs> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Song not found!");
            }
            Songs entity = List.get(0);            
            DTO = ConvertEntityToDTO(entity);
        } finally {
            session.close();
        }
        return DTO;
    }
    
    @Override
    public UUID Add(SongData Data) throws Exception {
        Songs entity = new Songs();
        entity.setDate(Data.PublishDate);
        entity.setGenre(Data.Genre);
        entity.setName(Data.Name);
        UUID Id;
        Session session = factory.openSession();
        try {
            Id = (UUID) session.save(entity);
        } catch (Exception exp) {
            throw new EntityCannotByCreatedException("Could not save Song data! See inner exception!", exp);
        } finally {
            session.close();
        }
        return Id;
    }
    
    @Override
    public void Edit(UUID Key, SongData Data) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Songs.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Songs> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Song not found!");
            }
            Songs entity = List.get(0);  
            entity.setDate(Data.PublishDate);
            entity.setGenre(Data.Genre);
            entity.setName(Data.Name);
            session.update(entity);
        } catch (HibernateException exp) {
            throw new EntityCannotBeEditedException("Song could not be updated! See inner exception!", exp);
        } finally {
            session.close();
        }
    }
    
    @Override
    public void Delete(UUID Key) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Songs.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Songs> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Songs not found!");
            }
            Songs entity = List.get(0);            
            session.delete(entity);
        } catch (HibernateException exp) {
            throw new EntityCannotBeDeletedException("Songs could not be deleted! See inner exception!", exp);
        } finally {
            session.close();
        }
    }
    
}
