/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories;

import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.common.utils.PasswordSecurityProvider;
import com.shadows.liquiblq.data.exceptions.InvalidEntiryProvidedBeforeInsertException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.utils.SessionFactoryContainer;
import com.shadows.liquiblq.data.utils.UsersValidator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.hibernate.Session;
import java.util.UUID;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author John
 */
public class UsersRepository {
   
    public static void AddUser(String Email,String Password,String Name) throws EntityCannotByCreatedException, SessionFactoryConfigurationException {
        try{
            Users newUser = new Users();
            newUser.setEmail(Email);
            newUser.setSalt(PasswordSecurityProvider.GenSalt(UsersValidator.SaltLength));        
            newUser.setPassword(PasswordSecurityProvider.GenPasswordHash(Password, newUser.getSalt()));
            UsersValidator.ValidateUserBeforeInsert(newUser);
            newUser.setName(Name);
            SessionFactory factory = SessionFactoryContainer.getFactory();
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.save(newUser);
                session.getTransaction().commit();
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidEntiryProvidedBeforeInsertException ex) {
            throw new EntityCannotByCreatedException("User was not created! Inner exception message: "+ex.getMessage());
        } 
    }
    public static UUID GenerateGUID(){
        UUID UniqueId;
        UniqueId = UUID.randomUUID();
        return UniqueId;
    }
    public static Users GetUserByEmailAndPassword(String Email, String Password) throws SessionFactoryConfigurationException{
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Criteria cr = factory.getCurrentSession().createCriteria(Users.class);
            cr.add(Restrictions.eq("email", Email));
            cr.add(Restrictions.eq("password", Password));
            Users results = (Users)cr.list().get(0);
            return results;
    }
    
    public static String GetUserSaltAndPasswordByUserEmail(SessionFactory factory , Users Email) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String Salt =  Email.getSalt();
        String Password = Email.getPassword();
        String passwordHash =  PasswordSecurityProvider.GenPasswordHash(Password, Salt);
        return passwordHash;
    }
}
