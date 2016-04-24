/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Artist;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mihail
 */
public class GetAllArtistsResponse extends JSONResponse{   
    public List<Artist> artists;

    public GetAllArtistsResponse(List<Artist> listOfArtists) {
        this.artists = listOfArtists;
    } 

    public GetAllArtistsResponse() {
        this.artists = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.artists);
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
        final GetAllArtistsResponse other = (GetAllArtistsResponse) obj;
        if (!Objects.equals(this.artists, other.artists)) {
            return false;
        }
        return true;
    }
    
    
}
