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
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.utils.SessionFactoryContainer;
import com.shadows.liquiblq.data.utils.UsersValidator;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author John
 */
public class UsersRepository {
    public static void AddUser(String Email,String Password,String Name) throws EntityCannotByCreatedException{                
        try {
            AddUser(SessionFactoryContainer.getFactory(), Email, Password, Name);
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotByCreatedException("User was not created! Inner exception message: "+ex.getMessage());
        }
    }
    public static void AddUser(SessionFactory factory,String Email,String Password,String Name) throws EntityCannotByCreatedException {
        Users newUser = new Users();
        newUser.setEmail(Email);
        newUser.setSalt(PasswordSecurityProvider.GenSalt(UsersValidator.SaltLength));        
        newUser.setPassword(Password);
        newUser.setName(Name);
        AddUser(factory,newUser);        
    }
    public static void AddUser(SessionFactory factory,Users User) throws EntityCannotByCreatedException{            
        try {
            User.setPassword(PasswordSecurityProvider.GenPasswordHash(User.getPassword(), User.getSalt()));
            UsersValidator.ValidateUserBeforeInsert(User);
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.save(User);
                session.getTransaction().commit();
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidEntiryProvidedBeforeInsertException ex) {
            throw new EntityCannotByCreatedException("User was not created! Inner exception message: "+ex.getMessage());
        } 
    }
}