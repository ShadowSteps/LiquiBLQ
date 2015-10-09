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
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.AlbumsRepository;
import com.shadows.liquiblq.data.repositories.SessionsRepository;
import java.util.List;
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
@RequestMapping("/album")
public class AlbumController {
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public JSONResponse doRegister(@RequestParam("id") UUID id) throws SessionFactoryConfigurationException, EntityCannotBeFoundException{
        Album album = AlbumsRepository.GetUserById(id);
        return new GetAlbumByIdResponse(album);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public JSONResponse doLogin() throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        try {
            List<Album> Albums  = AlbumsRepository.GetAllAlbums();
            return new GetAllAlbumsResponse(Albums); 
        }
        catch(EntityCannotBeFoundException Exp){
            return new ErrorResponse((Exp));
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
