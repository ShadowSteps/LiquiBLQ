/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories;

import com.shadows.liquiblq.common.utils.PasswordSecurityProvider;
import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.exceptions.InvalidEntiryProvidedBeforeInsertException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.utils.SessionFactoryContainer;
import com.shadows.liquiblq.data.utils.SessionsValidator;
import com.shadows.liquiblq.data.utils.UsersValidator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}
