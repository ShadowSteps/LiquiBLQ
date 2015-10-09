/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Songs;

/**
 *
 * @author toshiba
 */
public class getSongByIdResponse extends JSONResponse {
    public Songs Song;
    
    public getSongByIdResponse(Songs song){
        this.Song = song;
    }
}
