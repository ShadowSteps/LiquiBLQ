/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.Song;
import com.shadows.liquiblq.data.interfaces.dto.data.GenreData;
import com.shadows.liquiblq.data.interfaces.dto.data.SongData;
import java.time.Instant;
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
public class SongsSetTest {
    
    public SongsSetTest() {
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
        GenreData GData = new GenreData();
        GData.Name = "Genre_" + UUID.randomUUID();
        GenresSet ginstance = new GenresSet();        
        UUID GKey = ginstance.Add(GData);
        assertNotNull(GKey);
        assertNotSame(GKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));         
        SongData Data = new SongData();
        Data.Genre = GKey;
        Data.Name = "Song_" + UUID.randomUUID();
        Data.PublishDate = new Date();
        Data.Filename = "test.wav";
        SongsSet instance = new SongsSet();        
        UUID result = instance.Add(Data);
        assertNotNull(result);
        assertNotSame(result, UUID.fromString("00000000-0000-0000-0000-000000000000")); 
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        GenreData GData = new GenreData();
        GData.Name = "Genre_" + UUID.randomUUID();
        GenresSet ginstance = new GenresSet();        
        UUID GKey = ginstance.Add(GData);
        assertNotNull(GKey);
        assertNotSame(GKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));         
        SongData Data = new SongData();
        Data.Genre = GKey;
        Data.Name = "Song_" + UUID.randomUUID();
        Data.PublishDate = new Date();
        Data.Filename = "test.wav";
        SongsSet instance = new SongsSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000")); 
        Data.Name += "_2";
        instance.Edit(Key, Data);        
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        GenreData GData = new GenreData();
        GData.Name = "Genre_" + UUID.randomUUID();
        GenresSet ginstance = new GenresSet();        
        UUID GKey = ginstance.Add(GData);
        assertNotNull(GKey);
        assertNotSame(GKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));         
        SongData Data = new SongData();
        Data.Genre = GKey;
        Data.Name = "Song_" + UUID.randomUUID();
        Data.PublishDate = new Date();
        Data.Filename = "test.wav";
        SongsSet instance = new SongsSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));
        instance.Delete(Key);        
    }
    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        SongsSet instance = new SongsSet();        
        List<Song> result = instance.GetAll();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        GenreData GData = new GenreData();
        GData.Name = "Genre_" + UUID.randomUUID();
        GenresSet ginstance = new GenresSet();        
        UUID GKey = ginstance.Add(GData);
        assertNotNull(GKey);
        assertNotSame(GKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));         
        SongData Data = new SongData();
        Data.Genre = GKey;
        Data.Name = "Song_" + UUID.randomUUID();
        Data.PublishDate = new Date();
        Data.Filename = "test.wav";
        SongsSet instance = new SongsSet();        
        UUID Key = instance.Add(Data);
        assertNotNull(Key);
        assertNotSame(Key, UUID.fromString("00000000-0000-0000-0000-000000000000"));
        Song expResult = new Song();
        expResult.Genre = GKey;
        expResult.Id = Key;
        expResult.Name = Data.Name;
        expResult.PublishDate = Data.PublishDate;
        expResult.Filename = Data.Filename;
        Song result = instance.GetById(Key);
        assertEquals(expResult, result);        
    }
    
}
