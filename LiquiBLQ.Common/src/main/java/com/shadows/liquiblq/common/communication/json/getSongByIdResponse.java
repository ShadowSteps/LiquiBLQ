/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class getSongByIdResponse extends JSONResponse {
    public Songs Song;
    public List<Album> albums;

    public getSongByIdResponse(Songs Song, List<Album> albums) {
        this.Song = Song;
        this.albums = albums;
    }

    public Songs getSong() {
        return Song;
    }

    public void setSong(Songs Song) {
        this.Song = Song;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
    
}
