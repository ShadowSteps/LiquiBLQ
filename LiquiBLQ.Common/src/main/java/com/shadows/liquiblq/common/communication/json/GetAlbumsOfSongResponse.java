/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author John
 */
public class GetAlbumsOfSongResponse extends JSONResponse{
    public Song song;
    public List<Album> albums;

    public GetAlbumsOfSongResponse(List<Album> albums, Song song) {
        this.albums = albums;
        this.song = song;
    }
    
    public GetAlbumsOfSongResponse() {
        this.albums = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.albums);
        hash = 47 * hash + Objects.hashCode(this.song);
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
        final GetAlbumsOfSongResponse other = (GetAlbumsOfSongResponse) obj;
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        if (!Objects.equals(this.song, other.song)) {
            return false;
        }
        return true;
    }       
}
