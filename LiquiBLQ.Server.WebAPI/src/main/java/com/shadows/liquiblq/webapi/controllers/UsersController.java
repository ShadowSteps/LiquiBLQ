/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.utils.HashManager;
import com.shadows.liquiblq.data.interfaces.dto.User;
import com.shadows.liquiblq.data.interfaces.dto.data.SessionData;
import com.shadows.liquiblq.data.interfaces.dto.data.UserData;
import com.shadows.liquiblq.webapi.controllers.base.BaseAPIController;
import java.util.Objects;
import java.util.UUID;
import javax.ws.rs.BadRequestException;
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
public class UsersController extends BaseAPIController{
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JSONResponse doRegister(@RequestParam("Email") String Email,@RequestParam("Password") String Password,@RequestParam("Name") String Name) {
        try {
            String Salt = HashManager.GenerateStringSalt();
            UserData Data = new UserData();
            Data.Email = Email;
            Data.Password = HashManager.GeneratePassword(Password, Salt);
            Data.Salt = Salt;
            Data.Name = Name;
            Integer Id = Context.getUsersSet()
                    .Add(Data);            
            return new RegisterResponse(Boolean.TRUE, Id, Email);
        } catch (Exception ex) {
            return new ErrorResponse(ex);
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JSONResponse doLogin(@RequestParam("Email") String Email,@RequestParam("Password") String Password) {
        try {
            User user = Context.getUsersSet()
                    .GetByEmail(Email);
            String passwordHash = HashManager.GeneratePassword(Password, user.Salt);
            if (!Objects.equals(passwordHash, user.Password))
                throw new BadRequestException("Wrong login!");
            SessionData sessionData = new SessionData();
            sessionData.IsActive = true;
            sessionData.UserId = user.Id;
            UUID SessionId = Context.getSessionsSet()
                    .Add(sessionData);
            return new LoginResponse(Boolean.TRUE,SessionId , Email, user.Id); 
        }
        catch(Exception Exp){
            return new ErrorResponse((Exp));
        }
    }
}
