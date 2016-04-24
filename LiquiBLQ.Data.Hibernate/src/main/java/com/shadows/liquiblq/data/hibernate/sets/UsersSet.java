package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.hibernate.entities.Users;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeDeletedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeEditedException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.hibernate.sets.base.BaseSet;
import com.shadows.liquiblq.data.interfaces.dto.User;
import com.shadows.liquiblq.data.interfaces.dto.data.UserData;
import com.shadows.liquiblq.data.interfaces.sets.IUsersSet;
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
public class UsersSet extends BaseSet<Users, User> implements IUsersSet {
    
    @Override
    protected User ConvertEntityToDTO(Users entity) {
        User dto = new User();
        dto.DateRegistered = entity.getDateRegistered();
        dto.Email = entity.getEmail();
        dto.Id = entity.getId();
        dto.Name = entity.getName();
        dto.Password = entity.getPassword();
        dto.Salt = entity.getSalt();
        return dto;
    }
    
    @Override
    public List<User> GetAll() throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Users.class);
        List<User> DTOs;
        try {
            List<Users> List = cr.list();
            DTOs = ConvertEntityArrayToDTOArray(List);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return DTOs;
    }
    
    @Override
    public User GetById(Integer Id) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("id", Id));
        User DTO;
        try {
            List<Users> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("User not found!");
            }
            Users entity = List.get(0);            
            DTO = ConvertEntityToDTO(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return DTO;
    }
    
    @Override
    public Integer Add(UserData Data) throws Exception {
        Users entity = new Users();
        entity.setEmail(Data.Email);
        entity.setPassword(Data.Password);
        entity.setSalt(Data.Salt);
        entity.setName(Data.Name);
        Integer Id;
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Id = (Integer) session.save(entity);
            session.getTransaction().commit();
        } catch (Exception exp) {
            session.getTransaction().rollback();
            throw new EntityCannotByCreatedException("Could not save User data! See inner exception!", exp);
        } finally {
            session.close();
        }
        return Id;
    }
    
    @Override
    public void Edit(Integer Key, UserData Data) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Users> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("User not found!");
            }
            Users entity = List.get(0);   
            entity.setEmail(Data.Email);
            entity.setPassword(Data.Password);
            entity.setSalt(Data.Salt);
            entity.setName(Data.Name);
            session.update(entity);
            session.getTransaction().commit();
        } catch (HibernateException exp) {
            session.getTransaction().rollback();
            throw new EntityCannotBeEditedException("User could not be updated! See inner exception!", exp);
        } finally {
            session.close();
        }
    }
    
    @Override
    public void Delete(Integer Key) throws Exception {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("id", Key));
        try {
            List<Users> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("Users not found!");
            }
            Users entity = List.get(0);            
            session.delete(entity);
        } catch (HibernateException exp) {
            session.getTransaction().rollback();
            throw new EntityCannotBeDeletedException("Users could not be deleted! See inner exception!", exp);
        } finally {
            session.close();
        }
    }

    @Override
    public User GetByEmail(String Email) throws EntityCannotBeFoundException {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("email", Email));
        User DTO;
        try {
            List<Users> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("User not found!");
            }
            Users entity = List.get(0);            
            DTO = ConvertEntityToDTO(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return DTO;
    }

    @Override
    public User GetByEmailAndPassword(String Email, String Password) throws EntityCannotBeFoundException {
        Session session = factory.openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("email", Email));
        cr.add(Restrictions.eq("password", Password));
        User DTO;
        try {
            List<Users> List = cr.list();
            if (List.isEmpty()) {
                throw new EntityCannotBeFoundException("User not found!");
            }
            Users entity = List.get(0);            
            DTO = ConvertEntityToDTO(entity);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        return DTO;
    }
    
}
