/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class GetAlbumByIdResponse extends JSONResponse {
    public Album album;
    public List<Artist> artists;
    public List<Song> songs;

    public GetAlbumByIdResponse(Album albumObj, List<Artist> artists, List<Song> songs) {
        this.album = albumObj;
        this.artists = artists;
        this.songs = songs;
    }          
}
