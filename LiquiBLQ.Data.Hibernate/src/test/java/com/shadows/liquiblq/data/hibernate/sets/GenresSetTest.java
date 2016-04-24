/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.data.GenreData;
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
public class GenresSetTest {
    
    public GenresSetTest() {
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
        GenreData Data = new GenreData();
        Data.Name = "Genre_" + UUID.randomUUID();
        GenresSet instance = new GenresSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));         
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        GenreData Data = new GenreData();
        Data.Name = "Genre_" + UUID.randomUUID();
        GenresSet instance = new GenresSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));
        Data.Name += "_2";
        instance.Edit(Key, Data);        
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        GenreData Data = new GenreData();
        Data.Name = "Genre_" + UUID.randomUUID();
        GenresSet instance = new GenresSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));
        instance.Delete(Key);        
    }
    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        GenresSet instance = new GenresSet();
        List<Genre> result = instance.GetAll();
        assertFalse(result.isEmpty());     
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        GenreData Data = new GenreData();
        Data.Name = "Genre_" + UUID.randomUUID();
        GenresSet instance = new GenresSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));
        Genre expResult = new Genre();
        expResult.Id = Key;
        expResult.Name = Data.Name;
        Genre result = instance.GetById(Key);
        assertEquals(expResult, result);        
    }
    
    
}
