/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.artistResponse;
import com.shadows.liquiblq.common.communication.json.getSongByIdResponse;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Songs;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.ArtistsRepository;
import com.shadows.liquiblq.data.repositories.SongsRepository;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import com.shadows.liquiblq.webapi.validation.RequestValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toshiba
 */

@RestController
@RequestMapping("/Song")
public class SongsController {
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public ResponseEntity<JSONResponse> doGetById(@PathVariable("id") UUID id,@RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId) throws SessionFactoryConfigurationException, EntityCannotBeFoundException{
        try {
            RequestValidator.validateRequest(Session, UserId);    
            Songs Song = SongsRepository.GetSongById(id);
            return new ResponseEntity<JSONResponse>(
                new getSongByIdResponse(Song,new ArrayList<Album>() {}),
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
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public ResponseEntity<JSONResponse> doGetAll(@RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId) throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        try {
            RequestValidator.validateRequest(Session, UserId);    
            List<Songs> Songs  = SongsRepository.GetAllSongs();
            return new ResponseEntity<JSONResponse>(
                new GetAllSongsResponse(Songs), 
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
