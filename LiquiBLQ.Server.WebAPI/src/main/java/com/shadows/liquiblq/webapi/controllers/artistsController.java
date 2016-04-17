/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.repositories.AlbumsRepository;
import com.shadows.liquiblq.data.repositories.ArtistsRepository;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import com.shadows.liquiblq.webapi.validation.RequestValidator;
import java.util.List;
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
public class ArtistsController {
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public JSONResponse doGetById(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            RequestValidator.validateRequest(Session, UserId);    
            Artist artist = ArtistsRepository.GetArtistById(id);
            return new GetArtistByIdResponse(artist,
                    AlbumsRepository.GetAlbumsForArtist(artist)
            );
        }
        catch (EntityCannotBeFoundException | RequestValidationException  Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public JSONResponse GetAllARtists(@RequestParam("SessionKey") UUID Session,@RequestParam("UserId") Integer UserId){        
        try {
            RequestValidator.validateRequest(Session, UserId);    
            List<Artist> Artists = ArtistsRepository.GetAllArtists();
            return new GetAllArtistsResponse(Artists);
        }
        catch (EntityCannotBeFoundException | RequestValidationException  Exp) {
            return new ErrorResponse(Exp);
        }
    }
}
