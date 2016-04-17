/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.tests;

import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.webapi.controllers.UsersController;
import com.shadows.liquiblq.webapi.controllers.ArtistsController;
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
public class ArtistsControllerTests {
    
    public ArtistsControllerTests() {
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
    public void TestGetAll() throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        ArtistsController Controller = new ArtistsController();
        UsersController UserController = new UsersController();
        LoginResponse Response = (LoginResponse)UserController.doLogin("asdasd", "asd");
        JSONResponse Resp = Controller.GetAllARtists(Response.sessionKey, Response.id);
        Boolean Result = Boolean.TRUE;
    }
}
