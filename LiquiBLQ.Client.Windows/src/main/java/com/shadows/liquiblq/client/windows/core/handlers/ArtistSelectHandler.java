/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.tasks.LoadArtistInfoTast;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;

/**
 *
 * @author John
 */
public class ArtistSelectHandler implements EventHandler {   
    private final TableRow<Artist> ArtistToHandle;
    public ArtistSelectHandler(TableRow<Artist> ArtistToHandle) {
        this.ArtistToHandle = ArtistToHandle;
    }


    
    @Override
    public void handle(Event event) {
        if (!ArtistToHandle.isEmpty()){
            LoadArtistInfoTast task = new LoadArtistInfoTast(ArtistToHandle.getItem());
            task.run();
        }
    }
    
}
