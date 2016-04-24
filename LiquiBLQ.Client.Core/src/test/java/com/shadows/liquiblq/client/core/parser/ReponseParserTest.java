/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.parser;

import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetSongByIdResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class ReponseParserTest {
    
    public ReponseParserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testParseLoginReponse() throws Exception {
        System.out.println("ParseLoginReponse");
        UUID Rand = UUID.randomUUID();
        String Reponse = "{\"status\":\"true\",\"sessionKey\":\""+Rand+"\",\"email\":\"asd@acstre.com\",\"id\":\"3\"}";
        LoginResponse expResult = new LoginResponse(Boolean.TRUE, Rand, "asd@acstre.com", 3);
        LoginResponse result = ReponseParser.ParseLoginReponse(Reponse);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseRegisterReponse() throws Exception {
        System.out.println("ParseRegisterReponse");
        String Reponse = "{\"status\":\"true\",\"email\":\"asd@acstre.com\",\"id\":\"3\"}";
        RegisterResponse expResult = new RegisterResponse(Boolean.TRUE, 3,"asd@acstre.com" );
        RegisterResponse result = ReponseParser.ParseRegisterReponse(Reponse);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseGetAllArtistsReponse() throws Exception {
        System.out.println("ParseGetAllArtistsReponse");
        UUID Rand = UUID.randomUUID();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();
        String Reponse = "{\"artists\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"Nickname\":\"Test Nickname\",\"DateOfBirth\":\""+format.format(date)+"\"}]}";
        GetAllArtistsResponse expResult = new GetAllArtistsResponse();
        Artist a = new Artist();     
        a.DateOfBirth = date;        
        a.Id = Rand;
        a.Name = "Test";
        a.Nickname = "Test Nickname";
        expResult.artists.add(a);
        GetAllArtistsResponse result = ReponseParser.ParseGetAllArtistsReponse(Reponse);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseGetAllAlbumsReponse() throws Exception {
        System.out.println("ParseGetAllAlbumsReponse");
        UUID Rand = UUID.randomUUID();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();        
        String Reponse = "{\"albums\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\"}]}";
        GetAllAlbumsResponse expResult = new GetAllAlbumsResponse();
        Album a = new Album();
        a.Id = Rand;
        a.Name = "Test";
        a.PublishDate = date;
        expResult.albums.add(a);
        GetAllAlbumsResponse result = ReponseParser.ParseGetAllAlbumsReponse(Reponse);
        assertEquals(expResult, result);        
    }

    @Test
    public void testParseGetAllSongsReponse() throws Exception {
        System.out.println("ParseGetAllSongsReponse");
        UUID Rand = UUID.randomUUID();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();        
        String Reponse = "{\"songs\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\",\"Genre\":\""+Rand+"\"}]}";
        GetAllSongsResponse expResult = new GetAllSongsResponse();
        Song s = new Song();
        s.Genre = Rand;
        s.Id = Rand;
        s.Name = "Test";
        s.PublishDate = date;
        expResult.songs.add(s);
        GetAllSongsResponse result = ReponseParser.ParseGetAllSongsReponse(Reponse);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseGetAlbumByIdReponse() throws Exception {
        System.out.println("ParseGetAlbumByIdReponse");
        UUID Rand = UUID.randomUUID();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();        
        String Reponse = "{\"album\":{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\"},"
                + "\"artists\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"Nickname\":\"Test Nickname\",\"DateOfBirth\":\""+format.format(date)+"\"}],"
                + "\"songs\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\",\"Genre\":\""+Rand+"\"}]}";
        Album a = new Album();
        a.Id = Rand;
        a.Name = "Test";
        a.PublishDate = date;
        Artist ar = new Artist();     
        ar.DateOfBirth = date;        
        ar.Id = Rand;
        ar.Name = "Test";
        ar.Nickname = "Test Nickname";
        Song s = new Song();
        s.Genre = Rand;
        s.Id = Rand;
        s.Name = "Test";
        s.PublishDate = date;
        GetAlbumByIdResponse expResult = new GetAlbumByIdResponse();
        expResult.album = a;
        expResult.artists.add(ar);
        expResult.songs.add(s);
        GetAlbumByIdResponse result = ReponseParser.ParseGetAlbumByIdReponse(Reponse);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseGetSongByIdReponse() throws Exception {
        System.out.println("ParseGetSongByIdReponse");
        UUID Rand = UUID.randomUUID();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();        
        String Reponse = "{\"song\":{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\",\"Genre\":\""+Rand+"\"},"
                + "\"genre\":{\"Id\":\""+Rand+"\",\"Name\":\"Test\"},"
                + "\"albums\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\"}]}";
        Song s = new Song();
        s.Genre = Rand;
        s.Id = Rand;
        s.Name = "Test";
        s.PublishDate = date;
        Album a = new Album();
        a.Id = Rand;
        a.Name = "Test";
        a.PublishDate = date;
        Genre g = new Genre();
        g.Id = Rand;
        g.Name = "Test";
        GetSongByIdResponse expResult = new GetSongByIdResponse();
        expResult.song = s;
        expResult.albums.add(a);
        expResult.genre = g;
        GetSongByIdResponse result = ReponseParser.ParseGetSongByIdReponse(Reponse);
        assertEquals(expResult, result);
    }

    @Test
    public void testParseGetArtistByIdReponse() throws Exception {
        System.out.println("ParseGetArtistByIdReponse");
        UUID Rand = UUID.randomUUID();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date = new Date();        
        String Reponse = "{\"artist\":{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"Nickname\":\"Test Nickname\",\"DateOfBirth\":\""+format.format(date)+"\"},"               
                + "\"albums\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"PublishDate\":\""+format.format(date)+"\"}]}";
        Album a = new Album();
        a.Id = Rand;
        a.Name = "Test";
        a.PublishDate = date;
        Artist ar = new Artist();     
        ar.DateOfBirth = date;        
        ar.Id = Rand;
        ar.Name = "Test";
        ar.Nickname = "Test Nickname";
        GetArtistByIdResponse expResult = new GetArtistByIdResponse();
        expResult.albums.add(a);
        expResult.artist = ar;
        GetArtistByIdResponse result = ReponseParser.ParseGetArtistByIdReponse(Reponse);
        assertEquals(expResult, result);        
    }
    
}
