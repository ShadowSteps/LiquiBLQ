/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mihail
 */
@RestController
@RequestMapping("/artists")
public class artistsController {
    @RequestMapping(value = "get/{id}",method = RequestMethod.POST)
    public JSONResponse getArtist(@PathVariable UUID id, @RequestParam("sessionKey") String Email,@RequestParam("UserId") String Password) throws SessionFactoryConfigurationException{
       
        
        return null;
    }
    
    @RequestMapping(value = "getAll",methor = RequestMethod.POST)
    public JSONResponse GetAllARtists(@RequestParam("sessionKey") String Email,@RequestParam("UserId")){
        
        return null;
    }
}
