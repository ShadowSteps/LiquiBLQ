/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;

/**
 *
 * @author mihail
 */
public class GetAllSongsResponse extends JSONResponse{

    
    public List<Songs> listOfSongs;
    
    public void  setListofSongs(List<Songs> list){
        this.listOfSongs=list;
    }
    public List<Songs> getListOfSongs(){
        return this.listOfSongs;
    }
    public GetAllSongsResponse(List<Songs> ListOfSongs) {
        this.listOfSongs = ListOfSongs;
    }
    public GetAllSongsResponse(){
        
    }
}
