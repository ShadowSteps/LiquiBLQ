package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Sessions;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeEditedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.data.SessionData;
import com.shadows.liquiblq.data.interfaces.sets.ISessionsSet;
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
public class SessionsSet extends BaseSet<Sessions, com.shadows.liquiblq.data.interfaces.dto.Session> implements ISessionsSet {
    
    @Override
    protected com.shadows.liquiblq.data.interfaces.dto.Session ConvertEntityToDTO(Sessions entity) {
        com.shadows.liquiblq.data.interfaces.dto.Session dto = new com.shadows.liquiblq.data.interfaces.dto.Session();
        dto.DateCreated = entity.getDateCreated();
        dto.Id = entity.getId();
        dto.IsActive = entity.isActive();
        dto.UserId = entity.getUserId();
        return dto;
    }
    
    @Override
    public List<com.shadows.liquiblq.data.interfaces.dto.Session> GetAll() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Sessions.class);
        List<com.shadows.liquiblq.data.interfaces.dto.Session> DTOs;
        try {
            List<Sessions> List = cr.list();
            DTOs = ConvertEntityArrayToDTOArray(List);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return DTOs;
    }
    
    @Override
    public com.shadows.liquiblq.data.interfaces.dto.Session GetById(UUID Id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Sessions.class);
        cr.add(Restrictions.eq("id", Id));
        com.shadows.liquiblq.data.interfaces.dto.Session DTO;
        try {
            List<Sessions> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Session not found!");
            }
            Sessions entity = List.get(0);            
            DTO = ConvertEntityToDTO(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return DTO;
    }
    
    @Override
    public UUID Add(SessionData Data) throws Exception {
        Sessions entity = new Sessions();
        entity.setActive(true);
        entity.setUserId(Data.UserId);
        UUID Id;
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Id = (UUID) session.save(entity);
            session.getTransaction().commit();
        } catch (Exception exp) {
            session.getTransaction().rollback();
            throw new EntityCannotByCreatedException("Could not save Session data! See inner exception!", exp);
        } finally {
            session.close();
        }
        return Id;
    }
    
    @Override
    public void Edit(UUID Key, SessionData Data) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Sessions.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Sessions> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Session not found!");
            }
            Sessions entity = List.get(0);   
            entity.setActive(Data.IsActive);
            entity.setUserId(Data.UserId);
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException exp) {
            session.getTransaction().rollback();
            throw new EntityCannotBeEditedException("Session could not be updated! See inner exception!", exp);
        } finally {
            session.close();
        }
    }
    
    @Override
    public void Delete(UUID Key) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Sessions.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Sessions> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Sessions not found!");
            }
            Sessions entity = List.get(0);            
            session.delete(entity);
            session.getTransaction().commit();
        } catch (HibernateException exp) {
            session.getTransaction().rollback();
            throw new EntityCannotBeDeletedException("Sessions could not be deleted! See inner exception!", exp);
        } finally {
            session.close();
        }
    }    
}
      