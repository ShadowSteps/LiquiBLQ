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
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import java.util.UUID;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author John
 */
public class UsersRepository {
    public static List<Users> GetAllUsers() throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            List<Users> results = null;       
            try {                
                session.beginTransaction();
                Criteria cr = session.createCriteria(Users.class);                    
                List<Users> ListUsers = cr.list();       
                session.getTransaction().commit();
                return ListUsers;
            }
            catch(HibernateException Exp){
                session.getTransaction().rollback();
                throw new EntityCannotBeFoundException("Users cannot be fetched! Inner Exception: "+Exp.getMessage());
            }
            finally {
                session.disconnect();
            }                         
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("Users cannot be fetched! Inner exception message: "+ex.getMessage());
        }
    }
    public static Users AddUser(String Email,String Password,String Name) throws EntityCannotByCreatedException{                
        try {
            return AddUser(SessionFactoryContainer.getFactory(), Email, Password, Name);
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotByCreatedException("User was not created! Inner exception message: "+ex.getMessage());
        }
    }
    public static Users AddUser(SessionFactory factory,String Email,String Password,String Name) throws EntityCannotByCreatedException {
        Users newUser = new Users();
        newUser.setEmail(Email);
        newUser.setSalt(PasswordSecurityProvider.GenSalt(UsersValidator.SaltLength));        
        newUser.setPassword(Password);
        newUser.setName(Name);
        newUser.setDateRegistered(new Date());
        return AddUser(factory,newUser);        
    }
    public static UUID GenerateGUID(){
        UUID UniqueId;
        UniqueId = UUID.randomUUID();
        return UniqueId;
    }
    
    public static Users AddUser(SessionFactory factory,Users User) throws EntityCannotByCreatedException{            
        try {
            User.setPassword(PasswordSecurityProvider.GenPasswordHash(User.getPassword(), User.getSalt()));
            UsersValidator.ValidateUserBeforeInsert(User);
            Session session = factory.openSession();
            try {                
                session.beginTransaction();
                session.save(User);
                session.getTransaction().commit();
                return User;
            }
            catch(Exception Exp){
                session.getTransaction().rollback();
                throw Exp;
            }
            finally {
                session.disconnect();
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidEntiryProvidedBeforeInsertException ex) {
            throw new EntityCannotByCreatedException("User was not created! Inner exception message: "+ex.getMessage());
        } 
    }
    public static Users GetUserByEmail(String Email) throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            Users results = null;       
            try {                
                session.beginTransaction();
                Criteria cr = session.createCriteria(Users.class);     
                cr.add(Restrictions.eq("email", Email));
                List ListUsers = cr.list();
                if (ListUsers.isEmpty()){
                    throw new EntityCannotBeFoundException("User was not found!");
                }
                results = (Users)ListUsers.get(0);            
                session.getTransaction().commit();                
            }
            catch(HibernateException Exp){
                session.getTransaction().rollback();
                throw new EntityCannotBeFoundException("User was not found! Inner Exception: "+Exp.getMessage());
            }
            finally {
                session.disconnect();
            }  
            return results;                        
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("User was not found! Inner exception message: "+ex.getMessage());
        }
    }
    public static Users GetUserById(UUID id) throws SessionFactoryConfigurationException, Exception{
        try{
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            Users results = null;
            try {                
                session.beginTransaction();
                Criteria cr = session.createCriteria(Users.class);     
                cr.add(Restrictions.eq("id", id));
                List ListUsers = cr.list();
                if (ListUsers.isEmpty()){
                    throw new EntityCannotBeFoundException("User was not found!");
                }
                results = (Users)ListUsers.get(0);            
                session.getTransaction().commit();                
            }
            catch(HibernateException Exp){
                session.getTransaction().rollback();
                throw new EntityCannotBeFoundException("User was not found! Inner Exception: "+Exp.getMessage());
            }
            finally {
                session.disconnect();
            }  
        }catch(Exception e){
            throw(e);
        }
        return null;
    }
    public static Users GetUserByEmailAndPassword(String Email, String Password) throws EntityCannotBeFoundException{
        try {
            SessionFactory factory = SessionFactoryContainer.getFactory();
            Session session = factory.openSession();
            Users results = null;       
            try {                
                session.beginTransaction();
                Users SelectedUser = GetUserByEmail(Email);
                String Salt = SelectedUser.getSalt().trim();
                Password = PasswordSecurityProvider.GenPasswordHash(Password, Salt);
                Criteria cr = session.createCriteria(Users.class);     
                cr.add(Restrictions.and(
                    Restrictions.eq("email", Email),
                    Restrictions.eq("password", Password)
                ));
                List ListUsers = cr.list();
                if (ListUsers.isEmpty()){
                    throw new EntityCannotBeFoundException("User was not found!");
                }
                results = (Users)ListUsers.get(0);            
                session.getTransaction().commit();
                return results;
            }
            catch(EntityCannotBeFoundException | UnsupportedEncodingException | NoSuchAlgorithmException | HibernateException Exp){
                session.getTransaction().rollback();
                if (Exp instanceof EntityCannotBeFoundException){
                    throw new EntityCannotBeFoundException(Exp.getMessage());
                }
            }
            finally {
                session.disconnect();
            }          
            return results;
        } catch (SessionFactoryConfigurationException ex) {
            throw new EntityCannotBeFoundException("User was not found! Inner exception message: "+ex.getMessage());
        }
    }
    
}
