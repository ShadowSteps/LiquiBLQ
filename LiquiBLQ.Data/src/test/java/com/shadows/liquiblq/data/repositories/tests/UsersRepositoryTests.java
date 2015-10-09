/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.repositories.tests;

import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.repositories.UsersRepository;
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
public class UsersRepositoryTests {
    
    public UsersRepositoryTests() {
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
    public void TestGetUser(String Email,String Password) throws EntityCannotBeFoundException{
        UsersRepository.GetUserByEmailAndPassword(Email, Password);
    }
    public void TestAddUser(String Email,String Password) throws EntityCannotByCreatedException{
        UsersRepository.AddUser(Email, Password, RandomStringUtils.randomAlphabetic(10));
    }
    @Test
    public void TestUserInteractionValid() throws EntityCannotByCreatedException, EntityCannotBeFoundException{
        String Email = RandomStringUtils.randomAlphabetic(5) + "@" + RandomStringUtils.randomAlphabetic(3) + ".com";
        String Password = RandomStringUtils.randomAlphanumeric(25);
        TestAddUser(Email, Password);
        TestGetUser(Email, Password);
    }
    @Test
    public void TestUserInteractionInvalid() throws EntityCannotByCreatedException, EntityCannotBeFoundException{
        String Email = RandomStringUtils.random(5) + "" + RandomStringUtils.randomAlphabetic(3) + "//";
        String Password = "";
        TestAddUser(Email, Password);
        TestGetUser(Email, Password);
    }
    @Test
    public void TestGetAllUsers() throws EntityCannotBeFoundException{
        UsersRepository.GetAllUsers();
    }
}
