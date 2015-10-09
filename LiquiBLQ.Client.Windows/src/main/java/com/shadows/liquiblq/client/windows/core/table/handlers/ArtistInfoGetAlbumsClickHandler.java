/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.table.handlers;

import com.shadows.liquiblq.data.entitys.Album;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author John
 */
public class ArtistInfoGetAlbumsClickHandler implements EventHandler<Event>{
    private final List<Album> Albums;
    @Override
    
    public void handle(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArtistInfoGetAlbumsClickHandler(List<Album> Albums) {
        this.Albums = Albums;
    }
    
}
