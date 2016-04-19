/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.List;

public class GetSongByIdResponse extends JSONResponse {
    public Song song;
    public Genre genre;
    public List<Album> albums;
    public GetSongByIdResponse(Song song, Genre genre,List<Album> albums ){
        this.song = song;
        this.genre = genre;      
        this.albums = albums;
    }      
}
