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
    public JSONResponse doRegister(@RequestParam("Email") String Email,@RequestParam("Password") String Password,@RequestParam("Name") String Name){
        try {
            UsersRepository.AddUser(Email, Password, Name);
            return new RegisterResponse(Boolean.TRUE);
        } catch (EntityCannotByCreatedException ex) {
            return new ErrorResponse(ex);
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JSONResponse doLogin(@RequestParam("Email") String Email,@RequestParam("Password") String Password){
        try {
            UsersRepository.GetUserByEmail(Email, Password);
            return new LoginResponse(Boolean.TRUE);
        } catch (EntityCannotBeFoundException ex) {
            return new ErrorResponse(ex);
        }
    }
}
