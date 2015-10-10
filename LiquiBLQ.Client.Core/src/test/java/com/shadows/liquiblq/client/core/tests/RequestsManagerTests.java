/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.tests;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.getSongByIdResponse;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class RequestsManagerTests {
    
    public RequestsManagerTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TestUserRequests() throws HttpRequestErrorException, CannotParseResponseException{
        String Email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com";
        String Password = RandomStringUtils.randomAlphanumeric(25);
        RegisterResponse Resp = (RegisterResponse) RequestsManager.doRegisterRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", Email, Password,RandomStringUtils.randomAlphanumeric(10));
        LoginResponse Resp2 = (LoginResponse) RequestsManager.doLoginRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", Email, Password);
    }
    @Test
    public void TestArtistsRequests() throws HttpRequestErrorException, CannotParseResponseException{
        GetAllArtistsResponse Resp = (GetAllArtistsResponse) RequestsManager.doGetAllArtistsRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", UUID.fromString("0d65bd23-7096-4872-90f7-789bad390399"),49);
        GetArtistByIdResponse Resp2 = (GetArtistByIdResponse) RequestsManager.doGetArtistByIdRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", UUID.fromString("0d65bd23-7096-4872-90f7-789bad390399"), 49, UUID.fromString("aa4bb2d3-41f2-4aaa-b41c-fe85d81d773b"));
    }
    @Test
    public void TestAlbumsRequests() throws HttpRequestErrorException, CannotParseResponseException{
        GetAllAlbumsResponse Resp = (GetAllAlbumsResponse) RequestsManager.doGetAllAlbumsRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", UUID.fromString("0d65bd23-7096-4872-90f7-789bad390399"),49);
        GetAlbumByIdResponse Resp2 = (GetAlbumByIdResponse) RequestsManager.doGetAlbumByIdRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", UUID.fromString("0d65bd23-7096-4872-90f7-789bad390399"), 49, UUID.fromString("1f8fdb75-2cf4-4123-ae1e-25c524485679"));
    }
    @Test
    public void TestSongsRequests() throws HttpRequestErrorException, CannotParseResponseException{
        GetAllSongsResponse Resp = (GetAllSongsResponse) RequestsManager.doGetAllSongsRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", UUID.fromString("0d65bd23-7096-4872-90f7-789bad390399"),49);
        getSongByIdResponse Resp2 = (getSongByIdResponse) RequestsManager.doGetSongByIdRequest("http://localhost:8080/LiquiBLQ.Server.WebAPI-1.0/", UUID.fromString("0d65bd23-7096-4872-90f7-789bad390399"), 49, UUID.fromString("139ff27e-62ce-4680-860f-0886af2e79c1"));
    }
}
