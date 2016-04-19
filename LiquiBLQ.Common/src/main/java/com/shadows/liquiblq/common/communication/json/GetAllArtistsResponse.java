/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Artist;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mihail
 */
public class GetAllArtistsResponse extends JSONResponse{   
    public List<Artist> artists;

    public GetAllArtistsResponse(List<Artist> listOfArtists) {
        this.artists = listOfArtists;
    } 
}
