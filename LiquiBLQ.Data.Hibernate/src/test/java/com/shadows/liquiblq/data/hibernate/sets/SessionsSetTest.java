/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.Session;
import com.shadows.liquiblq.data.interfaces.dto.data.SessionData;
import com.shadows.liquiblq.data.interfaces.dto.data.UserData;
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
public class SessionsSetTest {
    
    public SessionsSetTest() {
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
        SessionData SessData = new SessionData();
        SessData.IsActive = true;
        SessData.UserId = Key;
        SessionsSet sessInstance = new SessionsSet();
        UUID SessId = sessInstance.Add(SessData);        
        assertNotNull(SessId);
        assertNotSame(SessId, UUID.fromString("00000000-0000-0000-0000-000000000000"));        
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
        SessionData SessData = new SessionData();
        SessData.IsActive = true;
        SessData.UserId = Key;
        SessionsSet sessInstance = new SessionsSet();
        UUID SessId = sessInstance.Add(SessData);        
        assertNotNull(SessId);
        assertNotSame(SessId, UUID.fromString("00000000-0000-0000-0000-000000000000"));     
        SessData.IsActive = false;
        sessInstance.Edit(SessId, SessData);        
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
        SessionData SessData = new SessionData();
        SessData.IsActive = true;
        SessData.UserId = Key;
        SessionsSet sessInstance = new SessionsSet();
        UUID SessId = sessInstance.Add(SessData);        
        assertNotNull(SessId);
        assertNotSame(SessId, UUID.fromString("00000000-0000-0000-0000-000000000000"));     
        sessInstance.Delete(SessId);        
    }
    
    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        SessionsSet instance = new SessionsSet();        
        List<Session> result = instance.GetAll();
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
        SessionData SessData = new SessionData();
        SessData.IsActive = true;
        SessData.UserId = Key;
        SessionsSet sessInstance = new SessionsSet();
        UUID SessId = sessInstance.Add(SessData);        
        assertNotNull(SessId);
        assertNotSame(SessId, UUID.fromString("00000000-0000-0000-0000-000000000000"));     
        Session result = sessInstance.GetById(SessId);
        Session expResult = new Session();
        expResult.IsActive = SessData.IsActive;
        expResult.Id = SessId;
        expResult.UserId = SessData.UserId;
        expResult.DateCreated = result.DateCreated;
        assertEquals(expResult, result);        
    }
}
