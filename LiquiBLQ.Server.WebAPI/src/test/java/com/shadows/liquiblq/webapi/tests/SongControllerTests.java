/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.tests;

import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.webapi.controllers.SongsController;
import com.shadows.liquiblq.webapi.controllers.UsersController;
import com.shadows.liquiblq.webapi.utils.SongReader;
import java.io.InputStream;
import java.util.UUID;
import javax.print.DocFlavor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author toshiba
 */
public class SongControllerTests {
    
    public SongControllerTests() {
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

    @Test
    public void FileRead() throws Exception{
        //SongReader reader = new SongReader("C:/Users/toshiba/Desktop/02 - Dilated Peoples - Worst Comes To Worst.mp3", 512);
        //reader.read();
    }
    @Test
    public void SongsTest() throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        SongsController contoll = new SongsController();
        UsersController UserController = new UsersController();
        LoginResponse Response = (LoginResponse)UserController.doLogin("asd", "asd");
        contoll.doGetById(UUID.fromString("139ff27e-62ce-4680-860f-0886af2e79c1"), Response.sessionKey, Response.id);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
