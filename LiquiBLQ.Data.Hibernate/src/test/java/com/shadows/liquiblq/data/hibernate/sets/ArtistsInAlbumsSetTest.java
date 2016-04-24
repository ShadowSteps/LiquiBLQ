/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.sets;

import com.shadows.liquiblq.data.interfaces.dto.ArtistInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.data.AlbumData;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistData;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistInAlbumData;
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
public class ArtistsInAlbumsSetTest {
    public UUID albumKey;
    public UUID artistKey;
    
    public ArtistsInAlbumsSetTest() {
    }
    
    @Before
    public void setUpTestMethod() throws Exception{
        ArtistData AData = new ArtistData();
        AData.DateOfBirth = new Date();
        AData.Name = "Artist_"+UUID.randomUUID();
        AData.Nickname = "Nickname_"+AData.Name.substring(7);
        ArtistsSet artistsInstance = new ArtistsSet();
        UUID AKey = artistsInstance.Add(AData);
        assertNotNull(AKey);
        assertNotSame(AKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));   
        AlbumData ALData = new AlbumData();
        ALData.Name = "Album_"+UUID.randomUUID();
        ALData.PublishDate = new Date();
        AlbumsSet albumInstance = new AlbumsSet();        
        UUID AlbumKey = albumInstance.Add(ALData);
        assertNotNull(AlbumKey);
        assertNotSame(AlbumKey, UUID.fromString("00000000-0000-0000-0000-000000000000"));   
        albumKey = AlbumKey;
        artistKey = AKey;
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
        ArtistInAlbumData Data = new ArtistInAlbumData();
        Data.Album = albumKey;
        Data.Artist = artistKey;
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);        
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        ArtistInAlbumData Data = new ArtistInAlbumData();
        Data.Album = albumKey;
        Data.Artist = artistKey;
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        instance.Edit(Key, Data);
    }

    @Test
    public void testDelete() throws Exception {
        ArtistInAlbumData Data = new ArtistInAlbumData();
        Data.Album = albumKey;
        Data.Artist = artistKey;
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        instance.Delete(Key);
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();
        List<ArtistInAlbum> result = instance.GetAll();
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("GetById");
        ArtistInAlbumData Data = new ArtistInAlbumData();
        Data.Album = albumKey;
        Data.Artist = artistKey;
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);
        ArtistInAlbum result = instance.GetById(Key);
        ArtistInAlbum expResult = new ArtistInAlbum();
        expResult.Album = Data.Album;
        expResult.Artist = Data.Artist;
        expResult.Id = Key;
        assertEquals(expResult, result);        
    }

    @Test
    public void testGetByAlbumId() throws Exception {
        System.out.println("GetByAlbumId");
        UUID Id = albumKey;
        ArtistInAlbumData Data = new ArtistInAlbumData();
        Data.Album = albumKey;
        Data.Artist = artistKey;
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);     
        List<ArtistInAlbum> result = instance.GetByAlbumId(Id);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetByArtistId() throws Exception {
        System.out.println("GetByArtistId");
        UUID Id = artistKey;
        ArtistInAlbumData Data = new ArtistInAlbumData();
        Data.Album = albumKey;
        Data.Artist = artistKey;
        ArtistsInAlbumsSet instance = new ArtistsInAlbumsSet();        
        Integer Key = instance.Add(Data);
        assertNotNull(Key);
        assertTrue(Key > 0);      
        List<ArtistInAlbum> result = instance.GetByArtistId(Id);
        assertFalse(result.isEmpty());
    }
    
}
