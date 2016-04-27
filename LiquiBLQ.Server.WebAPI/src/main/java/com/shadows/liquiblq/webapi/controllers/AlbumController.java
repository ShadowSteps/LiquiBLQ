/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfArtistResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfSongResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetSongsInAlbumResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.data.hibernate.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.ArtistInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import com.shadows.liquiblq.data.interfaces.dto.SongInAlbum;
import com.shadows.liquiblq.webapi.controllers.base.BaseAPIController;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AlbumController extends BaseAPIController{
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public  JSONResponse doGetById(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            this.Validator.ValidateRequest(Session, UserId);    
            Album album = Context.getAlbumsSet().GetById(id);
            List<ArtistInAlbum> artistInAlbums = Context.getArtistsInAlbumsSet()
                    .GetByAlbumId(id);
            List<SongInAlbum> songInAlbums = Context.getSongsInAlbumsSet()
                    .GetByAlbumId(id);
            List<Artist> artists = new ArrayList<>();
            List<Song> songs = new ArrayList<>();
            for (SongInAlbum songInAlbum : songInAlbums) {
                Song song = Context.getSongsSet()
                        .GetById(songInAlbum.Song);
                songs.add(song);
            }
            for (ArtistInAlbum artistInAlbum : artistInAlbums) {
                Artist artist = Context.getArtistsSet()
                        .GetById(artistInAlbum.Artist);
                artists.add(artist);
            }
            return new GetAlbumByIdResponse(
                album,
                artists,
                songs
            );
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getByArtist/{id}",method = RequestMethod.POST)
    public  JSONResponse doGetByArtistId(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            this.Validator.ValidateRequest(Session, UserId);    
            Artist artist = Context.getArtistsSet().GetById(id);
            List<ArtistInAlbum> artistInAlbums = Context.getArtistsInAlbumsSet()
                    .GetByArtistId(id);            
            List<Album> albums = new ArrayList<>();            
            for (ArtistInAlbum artistInAlbum : artistInAlbums) {
                Album album = Context.getAlbumsSet()
                        .GetById(artistInAlbum.Album);
                albums.add(album);
            }
            return new GetAlbumsOfArtistResponse(
                albums,
                artist
            );
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getBySong/{id}",method = RequestMethod.POST)
    public  JSONResponse doGetBySongId(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            this.Validator.ValidateRequest(Session, UserId);    
            Song song = Context.getSongsSet().GetById(id);
            List<SongInAlbum> songsInAlbum = Context.getSongsInAlbumsSet()
                    .GetBySongId(id);            
            List<Album> albums = new ArrayList<>();            
            for (SongInAlbum songInAlbum : songsInAlbum) {
                Album album = Context.getAlbumsSet()
                        .GetById(songInAlbum.Album);
                albums.add(album);
            }
            return new GetAlbumsOfSongResponse(
                albums,
                song
            );
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public JSONResponse doGetAll(@RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId) throws EntityCannotBeFoundException {
        try {
            this.Validator.ValidateRequest(Session, UserId);  
            List<Album> Albums  = Context.getAlbumsSet().GetAll();
            return new GetAllAlbumsResponse(Albums);
        }
        catch(Exception Exp){
            return new ErrorResponse(Exp);
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
