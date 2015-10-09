/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.getSongByIdResponse;
import com.shadows.liquiblq.data.entitys.Genre;
import com.shadows.liquiblq.data.entitys.Songs;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.exceptions.SessionFactoryConfigurationException;
import com.shadows.liquiblq.data.repositories.GenresRepository;
import com.shadows.liquiblq.data.repositories.SongsRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author toshiba
 */
public class SongsController {
    @RestController
    @RequestMapping("/Song")
    public class AlbumController {
        @RequestMapping(value = "/get",method = RequestMethod.POST)
        public JSONResponse doRegister(@RequestParam("id") UUID id) throws SessionFactoryConfigurationException, EntityCannotBeFoundException{
            try{
                Songs Song = SongsRepository.GetSongById(id);
                Genre genre = GenresRepository.GetGenreBySongId((UUID) Song.getId());
                return new getSongByIdResponse(Song,genre);
            }catch(EntityCannotBeFoundException Exp){
                return new ErrorResponse(Exp);
            }
        }
        @RequestMapping(value = "/getAll",method = RequestMethod.POST)
        public JSONResponse doLogin() throws EntityCannotBeFoundException, SessionFactoryConfigurationException{
            try {
                List<Songs> Songs  = SongsRepository.GetAllSongs();
                return new GetAllSongsResponse(Songs); 
            }
            catch(EntityCannotBeFoundException Exp){
                return new ErrorResponse((Exp));
            }
        }
    }
}
