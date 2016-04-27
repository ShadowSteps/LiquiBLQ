/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author John
 */
public class GetAlbumsOfArtistResponse extends JSONResponse{
    public Artist artist;
    public List<Album> albums;

    public GetAlbumsOfArtistResponse(List<Album> albums, Artist artist) {
        this.albums = albums;
        this.artist = artist;
    }
    
    public GetAlbumsOfArtistResponse() {
        this.albums = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.albums);
        hash = 47 * hash + Objects.hashCode(this.artist);
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
        final GetAlbumsOfArtistResponse other = (GetAlbumsOfArtistResponse) obj;
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        return true;
    }       
}
