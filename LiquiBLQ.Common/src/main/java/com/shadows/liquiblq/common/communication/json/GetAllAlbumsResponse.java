/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mihail
 */
public class GetAllAlbumsResponse extends JSONResponse{
    public List<Album> albums;
        
    public GetAllAlbumsResponse(List<Album> ListOfAlbums) {
        this.albums = ListOfAlbums;
    }
}
