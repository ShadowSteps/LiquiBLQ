/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories;

import com.shadows.liquiblq.common.utils.PasswordSecurityProvider;
import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.exceptions.InvalidEntiryProvidedBeforeInsertException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.utils.SessionFactoryContainer;
import com.shadows.liquiblq.data.utils.SessionsValidator;
import com.shadows.liquiblq.data.utils.UsersValidator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author John
 */
public class SessionsRepository {
    public static Sessions GenerateSessionForUser(Users User) throws EntityCannotByCreatedException {
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Sessions session = new Sessions();            
            session.setUserId(User.getId());
            session.setActive(true);
            session.setId(UUID.randomUUID());
            session.setDateCreated(new Date());
            SessionsValidator.ValidateUserInsert(session);
            Session DbSession = factory.openSession();
            try {                
                DbSession.beginTransaction();
                DbSession.save(session);
                DbSession.getTransaction().commit();
                return session;
            }
            catch(Exception Exp){
                DbSession.getTransaction().rollback();
                throw Exp;
            }
            finally {
                DbSession.disconnect();
            }
        } catch (SessionFactoryConfigurationException | InvalidEntiryProvidedBeforeInsertException ex) {
            throw new EntityCannotByCreatedException("Session was not created! Inner exception message: "+ex.getMessage());
        } 
    }
    public static Sessions GetSessionById(UUID id) throws EntityCannotBeFoundException {
        try{
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            Sessions results = null;
            try {                
                session.beginTransaction();
                Criteria cr = session.createCriteria(Sessions.class);     
                cr.add(Restrictions.eq("id", id));
                List ListUsers = cr.list();
                if (ListUsers.isEmpty()){
                    throw new EntityCannotBeFoundException("Session was not found!");
                }
                results = (Sessions)ListUsers.get(0);            
                session.getTransaction().commit();                
            }
            catch(HibernateException Exp){
                session.getTransaction().rollback();
                throw new EntityCannotBeFoundException("Session was not found! Inner Exception: "+Exp.getMessage());
            }
            finally {
                session.disconnect();
            }  
        }catch(Exception ex){
            throw new EntityCannotBeFoundException("User was not found! Inner exception message: "+ex.getMessage());
        }
        return null;
    }
}
