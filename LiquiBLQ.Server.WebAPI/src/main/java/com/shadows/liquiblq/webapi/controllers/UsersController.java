/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.SessionsRepository;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@RestController
@RequestMapping("/user")
public class UsersController {
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JSONResponse doRegister(@RequestParam("Email") String Email,@RequestParam("Password") String Password,@RequestParam("Name") String Name) throws SessionFactoryConfigurationException{
        try {
            Users User = UsersRepository.AddUser(Email, Password, Name);
            return new RegisterResponse(Boolean.TRUE, User.getId(), Email);
        } catch (EntityCannotByCreatedException ex) {
            return new ErrorResponse(ex);
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JSONResponse doLogin(@RequestParam("Email") String Email,@RequestParam("Password") String Password) throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        try {
            Users User = UsersRepository.GetUserByEmailAndPassword(Email, Password);
            Sessions Session = SessionsRepository.GenerateSessionForUser(User);
            return new LoginResponse(Boolean.TRUE,(UUID)Session.getId(), Email, User.getId()); 
        }
        catch(EntityCannotBeFoundException | EntityCannotByCreatedException Exp){
            return new ErrorResponse((Exp));
        }
    }
}
