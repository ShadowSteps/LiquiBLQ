/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mihail
 */
public class GetAllSongsResponse extends JSONResponse{   
    public List<Song> songs;
        
    public GetAllSongsResponse(List<Song> ListOfSongs) {
        this.songs = ListOfSongs;
    }

    public GetAllSongsResponse() {
        this.songs = new ArrayList<>();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.songs);
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
        final GetAllSongsResponse other = (GetAllSongsResponse) obj;
        if (!Objects.equals(this.songs, other.songs)) {
            return false;
        }
        return true;
    }
    
    
}
