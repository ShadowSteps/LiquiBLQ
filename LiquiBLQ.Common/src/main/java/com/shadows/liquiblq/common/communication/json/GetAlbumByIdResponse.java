/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Album;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class GetAlbumByIdResponse extends JSONResponse {
    public Album Albumobj;
    
    public GetAlbumByIdResponse(Album albumItem) {
        this.Albumobj = albumItem;
    }

}
