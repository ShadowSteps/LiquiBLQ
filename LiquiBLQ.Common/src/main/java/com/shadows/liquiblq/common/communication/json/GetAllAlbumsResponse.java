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
 * @author mihail
 */
public class GetAllAlbumsResponse extends JSONResponse{
    public List<Album> listOfAlbums;
    
    public List<Album> getListOfAlbums(){
        return this.listOfAlbums;
    }
    
    public void setListofAlbums(List<Album> list){
        this.listOfAlbums = list;
    }
    
    public GetAllAlbumsResponse(List<Album> ListOfAlbums) {
        this.listOfAlbums = ListOfAlbums;
    }
    public GetAllAlbumsResponse(){
        
    }
}
