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
import com.shadows.liquiblq.data.interfaces.dto.Artist;
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
        String Reponse = "{\"artists\":[{\"Id\":\""+Rand+"\",\"Name\":\"Test\",\"Nickname\":\"Test Nickname\",\"DateOfBirth\":\"2016-01-01T12:01:01.000+0200\"}]}";
        GetAllArtistsResponse expResult = new GetAllArtistsResponse();
        Artist a = new Artist();
        Calendar c = Calendar.getInstance();
        c.set(2016, 0, 1, 12, 1, 1);
        a.DateOfBirth = c.getTime();        
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
        String Reponse = "";
        GetAllAlbumsResponse expResult = null;
        GetAllAlbumsResponse result = ReponseParser.ParseGetAllAlbumsReponse(Reponse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testParseGetAllSongsReponse() throws Exception {
        System.out.println("ParseGetAllSongsReponse");
        String Reponse = "";
        GetAllSongsResponse expResult = null;
        GetAllSongsResponse result = ReponseParser.ParseGetAllSongsReponse(Reponse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testParseGetAlbumByIdReponse() throws Exception {
        System.out.println("ParseGetAlbumByIdReponse");
        String Reponse = "";
        GetAlbumByIdResponse expResult = null;
        GetAlbumByIdResponse result = ReponseParser.ParseGetAlbumByIdReponse(Reponse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testParseGetSongByIdReponse() throws Exception {
        System.out.println("ParseGetSongByIdReponse");
        String Reponse = "";
        GetSongByIdResponse expResult = null;
        GetSongByIdResponse result = ReponseParser.ParseGetSongByIdReponse(Reponse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testParseGetArtistByIdReponse() throws Exception {
        System.out.println("ParseGetArtistByIdReponse");
        String Reponse = "";
        GetArtistByIdResponse expResult = null;
        GetArtistByIdResponse result = ReponseParser.ParseGetArtistByIdReponse(Reponse);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
