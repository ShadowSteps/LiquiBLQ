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

/**
 *
 * @author toshiba
 */
public class GetArtistByIdResponse extends JSONResponse {
    public Artist artist;
    public List<Album> albums;

    public GetArtistByIdResponse(Artist artist, List<Album> albums) {
        this.artist = artist;
        this.albums = albums;
    }       
}
