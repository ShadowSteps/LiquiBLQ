/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.SongInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.data.AlbumData;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistData;
import com.shadows.liquiblq.data.interfaces.dto.data.GenreData;
import com.shadows.liquiblq.data.interfaces.dto.data.SongData;
import com.shadows.liquiblq.data.interfaces.dto.data.SongInAlbumData;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author John
 */
public class SongsInAlbumsSetTest {
    
    public UUID albumKey;
    public UUID songKey;
    
    public SongsInAlbumsSetTest() {
    }
    
    @Before
    public void setUpTestMethod() throws Exception{
        GenreData GData = new GenreData();
        GData.Name = "Genre_" + UUID.randomUUID();
        GenresSet ginstance = new GenresSet();        
        UUID GKey = ginstance.Add(GData);
        assertNotNull(GKey);
        assertNotSame(GKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));         
        SongData songData = new SongData();
        songData.Genre = GKey;
        songData.Name = "Song_" + UUID.randomUUID();
        songData.PublishDate = new Date();
        songData.Filename = "test.wav";
        SongsSet SongInstance = new SongsSet();        
        UUID SongKey = SongInstance.Add(songData);
        assertNotNull(SongKey);
        assertNotSame(SongKey, UUID.fromString("00000000-0000-0000-0000-000000000000")); 
        AlbumData ALData = new AlbumData();
        ALData.Name = "Album_"+UUID.randomUUID();
        ALData.PublishDate = new Date();
        AlbumsSet albumInstance = new AlbumsSet();        
        UUID AlbumKey = albumInstance.Add(ALData);
        assertNotNull(AlbumKey);
        assertNotSame(AlbumKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));   
        albumKey = AlbumKey;
        songKey = SongKey;
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
        SongInAlbumData Data = new SongInAlbumData();
        Data.Album = albumKey;
        Data.Song = songKey;
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0); 
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        SongInAlbumData Data = new SongInAlbumData();
        Data.Album = albumKey;
        Data.Song = songKey;
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0); 
        instance.Edit(Key, Data);        
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("Delete");
        SongInAlbumData Data = new SongInAlbumData();
        Data.Album = albumKey;
        Data.Song = songKey;
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        Integer Key = instance.Add(Data);        
        assertNotNull(Key);
        assertTrue(Key > 0); 
        instance.Delete(Key);        
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        List<SongInAlbum> result = instance.GetAll();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        SongInAlbumData Data = new SongInAlbumData();
        Data.Album = albumKey;
        Data.Song = songKey;
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        Integer Key = instance.Add(Data);        
        assertNotNull(Key);
        assertTrue(Key > 0); 
        SongInAlbum result = instance.GetById(Key);
        SongInAlbum expResult = new SongInAlbum();
        expResult.Album = albumKey;
        expResult.Song = songKey;
        expResult.Id = Key;
        assertEquals(expResult, result);        
    }

    @Test
    public void testGetBySongId() throws Exception {
        System.out.println("GetBySongId");
        SongInAlbumData Data = new SongInAlbumData();
        Data.Album = albumKey;
        Data.Song = songKey;
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        Integer Key = instance.Add(Data);        
        assertNotNull(Key);
        assertTrue(Key > 0); 
        List<SongInAlbum> result = instance.GetBySongId(songKey);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetByAlbumId() throws Exception {
        System.out.println("GetByAlbumId");
        SongInAlbumData Data = new SongInAlbumData();
        Data.Album = albumKey;
        Data.Song = songKey;
        SongsInAlbumsSet instance = new SongsInAlbumsSet();        
        Integer Key = instance.Add(Data);        
        assertNotNull(Key);
        assertTrue(Key > 0); 
        List<SongInAlbum> result = instance.GetByAlbumId(albumKey);
        assertFalse(result.isEmpty());
    }
    
}
