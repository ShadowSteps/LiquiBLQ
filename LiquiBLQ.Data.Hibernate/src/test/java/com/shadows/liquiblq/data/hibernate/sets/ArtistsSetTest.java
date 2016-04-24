/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistData;
import java.util.Date;
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
public class ArtistsSetTest {
    
    public ArtistsSetTest() {
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
        ArtistData Data = new ArtistData();
        Data.DateOfBirth = new Date();
        Data.Name = "Artist_"+UUID.randomUUID();
        Data.Nickname = "Nickname_"+Data.Name.substring(7);
        ArtistsSet instance = new ArtistsSet();
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));          
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        ArtistData Data = new ArtistData();
        Data.DateOfBirth = new Date();
        Data.Name = "Artist_"+UUID.randomUUID();
        Data.Nickname = "Nickname_"+Data.Name.substring(7);
        ArtistsSet instance = new ArtistsSet();
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));     
        Data.Name += "_2";
        instance.Edit(Key, Data);        
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        ArtistData Data = new ArtistData();
        Data.DateOfBirth = new Date();
        Data.Name = "Artist_"+UUID.randomUUID();
        Data.Nickname = "Nickname_"+Data.Name.substring(7);
        ArtistsSet instance = new ArtistsSet();
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));     
        instance.Delete(Key);        
    }
    
    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        ArtistsSet instance = new ArtistsSet();
        List<Artist> result = instance.GetAll();
        assertFalse(result.isEmpty());                
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        ArtistData Data = new ArtistData();
        Data.DateOfBirth = new Date();
        Data.Name = "Artist_"+UUID.randomUUID();
        Data.Nickname = "Nickname_"+Data.Name.substring(7);
        ArtistsSet instance = new ArtistsSet();
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));   
        Artist expResult = new Artist();
        expResult.DateOfBirth = Data.DateOfBirth;
        expResult.Id = Key;
        expResult.Name = Data.Name;
        expResult.Nickname = Data.Nickname;
        Artist result = instance.GetById(Key);
        assertEquals(expResult, result);        
    }
}
