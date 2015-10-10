/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;

/**
 *
 * @author toshiba
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class GetArtistByIdResponse extends JSONResponse {
    public Artist artist;
    public List<Album> albums;

    public GetArtistByIdResponse(Artist artist, List<Album> albums) {
        this.artist = artist;
        this.albums = albums;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
    public GetArtistByIdResponse(){
    }
    
    
}
