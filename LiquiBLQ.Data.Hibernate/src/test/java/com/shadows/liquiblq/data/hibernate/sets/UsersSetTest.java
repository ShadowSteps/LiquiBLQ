/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.User;
import com.shadows.liquiblq.data.interfaces.dto.data.UserData;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class UsersSetTest {
    
    public UsersSetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }   

    @Test
    public void testAdd() throws Exception {
        System.out.println("Add");
        UserData Data = new UserData();
        UUID Rand = UUID.randomUUID();        
        Data.Email = Rand+"@mail.bg";
        Data.Name = "Name_"+Rand;
        Data.Password = Rand.toString();
        Data.Salt = Rand.toString();        
        UsersSet instance = new UsersSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        UserData Data = new UserData();
        UUID Rand = UUID.randomUUID();        
        Data.Email = Rand+"@mail.bg";
        Data.Name = "Name_"+Rand;
        Data.Password = Rand.toString();
        Data.Salt = Rand.toString();        
        UsersSet instance = new UsersSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        Data.Name += "_2";
        instance.Edit(Key, Data);        
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        UserData Data = new UserData();
        UUID Rand = UUID.randomUUID();        
        Data.Email = Rand+"@mail.bg";
        Data.Name = "Name_"+Rand;
        Data.Password = Rand.toString();
        Data.Salt = Rand.toString();        
        UsersSet instance = new UsersSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        instance.Delete(Key);        
    }

    @Test
    public void testGetByEmail() throws Exception {
        System.out.println("GetByEmail");
        UserData Data = new UserData();
        UUID Rand = UUID.randomUUID();        
        Data.Email = Rand+"@mail.bg";
        Data.Name = "Name_"+Rand;
        Data.Password = Rand.toString();
        Data.Salt = Rand.toString();        
        UsersSet instance = new UsersSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        User expResult = new User();
        expResult.Email = Data.Email;
        expResult.Id = Key;
        expResult.Name = Data.Name;
        expResult.Password = Data.Password;
        expResult.Salt = Data.Salt;
        User result = instance.GetByEmail(Data.Email);
        expResult.DateRegistered = result.DateRegistered;
        assertEquals(expResult, result);        
    }

    @Test
    public void testGetByEmailAndPassword() throws Exception {
        System.out.println("GetByEmailAndPassword");
        UserData Data = new UserData();
        UUID Rand = UUID.randomUUID();        
        Data.Email = Rand+"@mail.bg";
        Data.Name = "Name_"+Rand;
        Data.Password = Rand.toString();
        Data.Salt = Rand.toString();        
        UsersSet instance = new UsersSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        User expResult = new User();
        expResult.Email = Data.Email;
        expResult.Id = Key;
        expResult.Name = Data.Name;
        expResult.Password = Data.Password;
        expResult.Salt = Data.Salt;
        User result = instance.GetByEmailAndPassword(Data.Email, Data.Password);
        expResult.DateRegistered = result.DateRegistered;
        assertEquals(expResult, result);        
    }
    
    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        UsersSet instance = new UsersSet();
        List<User> result = instance.GetAll();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        UserData Data = new UserData();
        UUID Rand = UUID.randomUUID();        
        Data.Email = Rand+"@mail.bg";
        Data.Name = "Name_"+Rand;
        Data.Password = Rand.toString();
        Data.Salt = Rand.toString();        
        UsersSet instance = new UsersSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        User expResult = new User();
        expResult.Email = Data.Email;
        expResult.Id = Key;
        expResult.Name = Data.Name;
        expResult.Password = Data.Password;
        expResult.Salt = Data.Salt;
        User result = instance.GetById(Key);
        expResult.DateRegistered = result.DateRegistered;
        assertEquals(expResult, result);        
    }
    
}
