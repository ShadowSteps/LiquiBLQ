/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.data.AlbumData;
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
public class AlbumsSetTest {
    public AlbumsSetTest() {
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
        AlbumData Data = new AlbumData();
        Data.Name = "Album_"+UUID.randomUUID();
        Data.PublishDate = new Date();
        AlbumsSet instance = new AlbumsSet();        
        UUID result = instance.Add(Data);
        assertNotNull(result);
        assertNotSame(result, UUID.fromString("00000000-0000-0000-0000-000000000000"));        
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");         
        AlbumData Data = new AlbumData();
        Data.Name = "Album_"+UUID.randomUUID();
        Data.PublishDate = new Date();
        AlbumsSet instance = new AlbumsSet();
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));        
        Data.Name = Data.Name+"_2";
        instance.Edit(Key, Data);        
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        AlbumData Data = new AlbumData();
        Data.Name = "Album_"+UUID.randomUUID();
        Data.PublishDate = new Date();
        AlbumsSet instance = new AlbumsSet();
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));   
        instance.Delete(Key);
    }

    @Test
    public void testGetAll() {
        System.out.println("GetAll");
        AlbumsSet instance = new AlbumsSet();
        List<Album> result = instance.GetAll();
        assertFalse(result.isEmpty());        
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        AlbumData Data = new AlbumData();
        Data.Name = "Album_"+UUID.randomUUID();
        Data.PublishDate = new Date();
        AlbumsSet instance = new AlbumsSet();
        UUID Key = instance.Add(Data);
        Album expResult = new Album();
        expResult.Id = Key;
        expResult.Name = Data.Name;
        expResult.PublishDate = Data.PublishDate;
        Album result = instance.GetById(Key);
        assertEquals(expResult, result);        
    }
    
}
