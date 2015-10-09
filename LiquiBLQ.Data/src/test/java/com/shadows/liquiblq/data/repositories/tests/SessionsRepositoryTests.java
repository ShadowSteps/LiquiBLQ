/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories.tests;

import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.repositories.SessionsRepository;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import java.util.List;
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
public class SessionsRepositoryTests {
    
    public SessionsRepositoryTests() {
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
    public void TestSessionGeneration() throws EntityCannotBeFoundException, Exception{
        List<Users> UserList = UsersRepository.GetAllUsers();
        if (UserList.isEmpty()){
            throw new Exception("Test failed: Not users in database!");
        }
        Users User = (Users)UserList.get(0);
        SessionsRepository.GenerateSessionForUser(User);
    }
}
