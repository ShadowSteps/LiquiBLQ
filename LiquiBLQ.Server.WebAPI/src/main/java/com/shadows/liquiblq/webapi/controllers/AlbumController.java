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
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.getSongByIdResponse;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Songs;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.AlbumsRepository;
import com.shadows.liquiblq.data.repositories.SessionsRepository;
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
 * @author John
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public ResponseEntity<JSONResponse> doGetById(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            RequestValidator.validateRequest(Session, UserId);    
            Album album = AlbumsRepository.GetAlbumById(id);
            return new ResponseEntity<JSONResponse>(
                new GetAlbumByIdResponse(album,new ArrayList<Artist>(),new ArrayList<Songs>()),
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
    public ResponseEntity<JSONResponse> doGetAll() throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        try {
            List<Album> Albums  = AlbumsRepository.GetAllAlbums();
            return new ResponseEntity<JSONResponse>(
                new GetAllAlbumsResponse(Albums),
                HttpStatus.OK
            );
        }
        catch(EntityCannotBeFoundException Exp){
            return new ResponseEntity<JSONResponse>(
                new ErrorResponse(Exp),
                HttpStatus.BAD_REQUEST
            );
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
