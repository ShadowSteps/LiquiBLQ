/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Genre;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;

/**
 *
 * @author toshiba
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class getSongByIdResponse extends JSONResponse {
    public Songs Song;
    public Genre songGenre;
    public List<Album> albums;
    public getSongByIdResponse(Songs song, Genre genre,List<Album> albums ){
        this.Song = song;
        this.songGenre = genre;      
        this.albums = albums;
    }

    public Songs getSong() {
        return Song;
    }

    public void setSong(Songs Song) {
        this.Song = Song;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public getSongByIdResponse() {
    }
    
}
