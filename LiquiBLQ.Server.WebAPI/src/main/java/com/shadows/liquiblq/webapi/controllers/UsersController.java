/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import com.shadows.liquiblq.webapi.responses.json.ErrorResponse;
import com.shadows.liquiblq.webapi.responses.json.JSONResponse;
import com.shadows.liquiblq.webapi.responses.json.RegisterResponse;
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
}
