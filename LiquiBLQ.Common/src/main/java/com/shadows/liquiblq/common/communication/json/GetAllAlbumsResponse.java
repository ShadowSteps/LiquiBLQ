/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mihail
 */
public class GetAllAlbumsResponse extends JSONResponse{
    public List<Album> albums;
        
    public GetAllAlbumsResponse(List<Album> ListOfAlbums) {
        this.albums = ListOfAlbums;
    }

    public GetAllAlbumsResponse() {
        this.albums = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final GetAllAlbumsResponse other = (GetAllAlbumsResponse) obj;
        if (!Objects.equals(this.albums, other.albums)) {
            return false;
        }
        return true;
    }
    
    
}
