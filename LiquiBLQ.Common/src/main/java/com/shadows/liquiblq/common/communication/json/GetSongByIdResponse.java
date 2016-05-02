/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetSongByIdResponse extends JSONResponse {
    public Song song;
    public Genre genre;
    public List<Album> albums;
    public GetSongByIdResponse(Song song, Genre genre,List<Album> albums ){
        this.song = song;
        this.genre = genre;      
        this.albums = albums;
    }  

    public GetSongByIdResponse() {
        this.albums = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.song);
        hash = 29 * hash + Objects.hashCode(this.genre);
        hash = 29 * hash + Objects.hashCode(this.albums);
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
        final GetSongByIdResponse other = (GetSongByIdResponse) obj;
        if (!Objects.equals(this.song, other.song)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        return true;
    }
    
    
}
