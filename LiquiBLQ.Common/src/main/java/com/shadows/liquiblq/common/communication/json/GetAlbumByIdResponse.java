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
import java.util.Objects;

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

    public GetAlbumByIdResponse() {
        this.artists = new ArrayList<>();
        this.songs = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.album);
        hash = 53 * hash + Objects.hashCode(this.artists);
        hash = 53 * hash + Objects.hashCode(this.songs);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GetAlbumByIdResponse other = (GetAlbumByIdResponse) obj;
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.artists, other.artists)) {
            return false;
        }
        if (!Objects.equals(this.songs, other.songs)) {
            return false;
        }
        return true;
    }
    
    
}
