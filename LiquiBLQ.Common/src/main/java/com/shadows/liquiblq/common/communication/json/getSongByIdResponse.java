/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Genre;
import com.shadows.liquiblq.data.entitys.Songs;

/**
 *
 * @author toshiba
 */
public class getSongByIdResponse extends JSONResponse {
    public Songs Song;
    public Genre songGenre;
    
    public getSongByIdResponse(Songs song, Genre genre ){
        this.Song = song;
        this.songGenre = genre;      
    }
}
