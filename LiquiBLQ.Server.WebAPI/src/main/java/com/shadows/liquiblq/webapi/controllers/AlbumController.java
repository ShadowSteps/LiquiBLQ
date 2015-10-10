/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.AlbumsRepository;
import com.shadows.liquiblq.data.repositories.ArtistsRepository;
import com.shadows.liquiblq.data.repositories.SongsRepository;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import com.shadows.liquiblq.webapi.validation.RequestValidator;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public  JSONResponse doGetById(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            RequestValidator.validateRequest(Session, UserId);    
            Album album = AlbumsRepository.GetAlbumById(id);
            return new GetAlbumByIdResponse(
                album,
                ArtistsRepository.GetArtistsForAlbum(album),
                SongsRepository.GetSongsForAlbum(album)
            );
        }
        catch (EntityCannotBeFoundException | RequestValidationException  Exp) {
            return new ErrorResponse(Exp);
        }
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public JSONResponse doGetAll() throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
        try {
            List<Album> Albums  = AlbumsRepository.GetAllAlbums();
            return new GetAllAlbumsResponse(Albums);
        }
        catch(EntityCannotBeFoundException Exp){
            return new ErrorResponse(Exp);
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
