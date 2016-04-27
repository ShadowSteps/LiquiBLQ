/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author John
 */
public class GetSongsInAlbumResponse extends JSONResponse{
    public Album album;
    public List<Song> songs;

    public GetSongsInAlbumResponse(List<Song> songs, Album album) {
        this.songs = songs;
        this.album = album;
    }
    
    public GetSongsInAlbumResponse() {
        this.songs = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.album);
        hash = 47 * hash + Objects.hashCode(this.songs);
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
        final GetSongsInAlbumResponse other = (GetSongsInAlbumResponse) obj;
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.songs, other.songs)) {
            return false;
        }
        return true;
    }       
}
