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
public class GetArtistsInAlbumResponse extends JSONResponse{
    public Album album;
    public List<Artist> artists;

    public GetArtistsInAlbumResponse(List<Artist> artists, Album album) {
        this.artists = artists;
        this.album = album;
    }
    
    public GetArtistsInAlbumResponse() {
        this.artists = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.album);
        hash = 47 * hash + Objects.hashCode(this.artists);
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
        final GetArtistsInAlbumResponse other = (GetArtistsInAlbumResponse) obj;
        if (!Objects.equals(this.album, other.album)) {
            return false;
        }
        if (!Objects.equals(this.artists, other.artists)) {
            return false;
        }
        return true;
    }       
}
