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
 * @author toshiba
 */
public class GetArtistByIdResponse extends JSONResponse {
    public Artist artist;
    public List<Album> albums;

    public GetArtistByIdResponse(Artist artist, List<Album> albums) {
        this.artist = artist;
        this.albums = albums;
    }

    public GetArtistByIdResponse() {
        this.albums = new ArrayList<>();        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.artist);
        hash = 97 * hash + Objects.hashCode(this.albums);
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
        final GetArtistByIdResponse other = (GetArtistByIdResponse) obj;
        if (!Objects.equals(this.artist, other.artist)) {
            return false;
        }
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        return true;
    }
    
    
}
