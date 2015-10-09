/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class GetAlbumByIdResponse extends JSONResponse {
    public Album albumObj;
    public List<Artist> artists;
    public List<Songs> songs;

    public GetAlbumByIdResponse(Album albumObj, List<Artist> artists, List<Songs> songs) {
        this.albumObj = albumObj;
        this.artists = artists;
        this.songs = songs;
    }

    public Album getAlbumObj() {
        return albumObj;
    }

    public void setAlbumObj(Album albumObj) {
        this.albumObj = albumObj;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }
    
    
}
