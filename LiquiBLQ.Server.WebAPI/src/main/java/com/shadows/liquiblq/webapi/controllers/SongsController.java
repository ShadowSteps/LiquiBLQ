/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers;

import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.GetSongByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetSongsInAlbumResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import com.shadows.liquiblq.data.interfaces.dto.SongInAlbum;
import com.shadows.liquiblq.webapi.controllers.base.BaseAPIController;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
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
public class SongsController extends BaseAPIController{
    @RequestMapping(value = "/get/{id}",method = RequestMethod.POST)
    public JSONResponse doGetById(@PathVariable("id") UUID id,@RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            Validator.ValidateRequest(Session, UserId);    
            Song song = Context.getSongsSet().GetById(id);
            Genre genre = Context.getGenresSet().GetById(song.Genre);
            List<SongInAlbum> songInAlbums = Context.getSongsInAlbumsSet()
                    .GetBySongId(id);
            List<Album> albums = new ArrayList<>();
            for (SongInAlbum songInAlbum : songInAlbums) {
                Album album = Context.getAlbumsSet()
                        .GetById(songInAlbum.Album);
                albums.add(album);
            }
            return new GetSongByIdResponse(song,genre,albums);
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/play/{id}",method = RequestMethod.GET)
    public void doPlayById(
            @PathVariable("id") UUID id,
            @RequestParam("sessionKey") UUID Session,
            @RequestParam("UserId") Integer UserId,
            HttpServletResponse response
    ){
        try {
            Validator.ValidateRequest(Session, UserId);    
            Song song = Context.getSongsSet().GetById(id);
            InputStream File = SongsController.class.getResourceAsStream("/songs/"+song.Filename);
            IOUtils.copy(File, response.getOutputStream());
            response.flushBuffer();
        }
        catch (Exception Exp) {
            throw new RuntimeException("IOError writing file to output stream");
        }
    }
    
    @RequestMapping(value = "/getByAlbum/{id}",method = RequestMethod.POST)
    public  JSONResponse doGetBySongId(@PathVariable UUID id, @RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId){
        try {
            this.Validator.ValidateRequest(Session, UserId);    
            Album album = Context.getAlbumsSet().GetById(id);
            List<SongInAlbum> songsInAlbum = Context.getSongsInAlbumsSet()
                    .GetByAlbumId(id);            
            List<Song> songs = new ArrayList<>();            
            for (SongInAlbum songInAlbum : songsInAlbum) {
                Song song = Context.getSongsSet()
                        .GetById(songInAlbum.Song);
                songs.add(song);
            }
            return new GetSongsInAlbumResponse(
                songs,
                album
            );
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
    
    @RequestMapping(value = "/getAll",method = RequestMethod.POST)
    public JSONResponse doGetAll(@RequestParam("sessionKey") UUID Session,@RequestParam("UserId") Integer UserId) {
        try {
            Validator.ValidateRequest(Session, UserId);    
            List<Song> Songs  = this.Context.getSongsSet()
                    .GetAll();
            return new GetAllSongsResponse(Songs);
        }
        catch (Exception Exp) {
            return new ErrorResponse(Exp);
        }
    }
}
