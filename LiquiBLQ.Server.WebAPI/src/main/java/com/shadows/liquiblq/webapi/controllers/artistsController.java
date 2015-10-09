/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.artistResponse;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.EntityCannotByCreatedException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.ArtistsRepository;
import com.shadows.liquiblq.data.repositories.SessionsRepository;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import com.shadows.liquiblq.webapi.validation.RequestValidator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public ResponseEntity<JSONResponse> GetAllARtists(@RequestParam("SessionKey") UUID Session,@RequestParam("UserId") Integer UserId){        
        try {
            RequestValidator.validateRequest(Session, UserId);    
            List<Artist> Artists = ArtistsRepository.GetAllArtists();
            return new ResponseEntity<JSONResponse>(
                new artistResponse(Artists),
                HttpStatus.OK
            );
        }
        catch (EntityCannotBeFoundException | RequestValidationException  Exp) {
            return new ResponseEntity<JSONResponse>(
                new ErrorResponse(Exp),
                HttpStatus.BAD_REQUEST
            );
        }
    }
}
