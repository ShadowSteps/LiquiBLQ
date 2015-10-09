/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Artist;
import java.util.List;

/**
 *
 * @author mihail
 */
public class artistResponse extends JSONResponse{

    public artistResponse(List<Artist> ListOfArtists) {
        this.listOfArtists = ListOfArtists;
    }
    public List<Artist> listOfArtists;
    
    public void  setListofArtists(List<Artist> list){
        this.listOfArtists=list;
    }
    public List<Artist> getListOfArtists(){
        return  this.listOfArtists;
    }
    public artistResponse(){
        
    }
}
