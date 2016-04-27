/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfSongResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistsInAlbumResponse;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.ArtistInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import com.shadows.liquiblq.data.interfaces.dto.SongInAlbum;
import com.shadows.liquiblq.webapi.controllers.base.BaseAPIController;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import com.shadows.liquiblq.webapi.validation.RequestValidator;
import java.util.ArrayList;
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
public class ArtistsController extends BaseAPIController{
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public JSONResponse doGetById(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            Validator.ValidateRequest(Session, UserId);    
            Artist artist = Context.getArtistsSet()
                    .GetById(id);
            List<ArtistInAlbum> artistInAlbums = Context.getArtistsInAlbumsSet()
                    .GetByArtistId(id);
            List<Album> albums = new ArrayList<>();
            for (ArtistInAlbum artistInAlbum : artistInAlbums) {
                Album album = Context.getAlbumsSet()
                        .GetById(artistInAlbum.Album);
                albums.add(album);
            }
            return new GetArtistByIdResponse(artist, albums);
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getByAlbum/{id}",method = RequestMethod.POST)
    public  JSONResponse doGetBySongId(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            this.Validator.ValidateRequest(Session, UserId);    
            Album album = Context.getAlbumsSet().GetById(id);
            List<ArtistInAlbum> artistsInAlbum = Context.getArtistsInAlbumsSet()
                    .GetByAlbumId(id);            
            List<Artist> artists = new ArrayList<>();            
            for (ArtistInAlbum artistInAlbum : artistsInAlbum) {
                Artist artist = Context.getArtistsSet()
                        .GetById(artistInAlbum.Artist);
                artists.add(artist);
            }
            return new GetArtistsInAlbumResponse(
                artists,
                album
            );
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public JSONResponse GetAllARtists(@RequestParam("SessionKey") UUID Session,@RequestParam("UserId") Integer UserId){        
        try {
            Validator.ValidateRequest(Session, UserId);    
            List<Artist> Artists = Context.getArtistsSet()
                    .GetAll();
            return new GetAllArtistsResponse(Artists);
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
}
