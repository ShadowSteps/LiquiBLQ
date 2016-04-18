package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Genres;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeEditedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.data.GenreData;
import com.shadows.liquiblq.data.interfaces.sets.IGenresSet;
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
public class GenresSet extends BaseSet<Genres, Genre> implements IGenresSet {
    
    @Override
    protected Genre ConvertEntityToDTO(Genres entity) {
        Genre dto = new Genre();
        dto.Id = entity.getId();
        dto.Name = entity.getName();
        return dto;
    }
    
    @Override
    public List<Genre> GetAll() throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Genres.class);
        List<Genre> DTOs;
        try {
            List<Genres> List = cr.list();
            DTOs = ConvertEntityArrayToDTOArray(List);
        } finally {
            session.close();
        }
        return DTOs;
    }
    
    @Override
    public Genre GetById(UUID Id) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Genres.class);
        cr.add(Restrictions.eq("id", Id));
        Genre DTO;
        try {
            List<Genres> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Genre not found!");
            }
            Genres entity = List.get(0);            
            DTO = ConvertEntityToDTO(entity);
        } finally {
            session.close();
        }
        return DTO;
    }
    
    @Override
    public UUID Add(GenreData Data) throws Exception {
        Genres entity = new Genres();
        entity.setName(Data.Name);
        UUID Id;
        Session session = factory.openSession();
        try {
            Id = (UUID) session.save(entity);
        } catch (Exception exp) {
            throw new EntityCannotByCreatedException("Could not save Genre data! See inner exception!", exp);
        } finally {
            session.close();
        }
        return Id;
    }
    
    @Override
    public void Edit(UUID Key, GenreData Data) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Genres.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Genres> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Genre not found!");
            }
            Genres entity = List.get(0);  
            entity.setName(Data.Name);
            session.update(entity);
        } catch (HibernateException exp) {
            throw new EntityCannotBeEditedException("Genre could not be updated! See inner exception!", exp);
        } finally {
            session.close();
        }
    }
    
    @Override
    public void Delete(UUID Key) throws Exception {
        Session session = factory.openSession();
        Criteria cr = session.createCriteria(Genres.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Genres> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Genres not found!");
            }
            Genres entity = List.get(0);            
            session.delete(entity);
        } catch (HibernateException exp) {
            throw new EntityCannotBeDeletedException("Genres could not be deleted! See inner exception!", exp);
        } finally {
            session.close();
        }
    }
    
}