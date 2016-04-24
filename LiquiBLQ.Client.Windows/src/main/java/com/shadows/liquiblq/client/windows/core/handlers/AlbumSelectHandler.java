/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.tasks.LoadAlbumtInfoTast;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;

/**
 *
 * @author John
 */
public class AlbumSelectHandler implements EventHandler {   
    private final TableRow<Album> AlbumToHandle;

    public AlbumSelectHandler(TableRow<Album> AlbumToHandle) {
        this.AlbumToHandle = AlbumToHandle;
    }
    
    @Override
    public void handle(Event event) {
        if (!AlbumToHandle.isEmpty()){
            LoadAlbumtInfoTast task = new LoadAlbumtInfoTast(this.AlbumToHandle.getItem());
            try {
                task.call();
            } catch (Exception ex) {
                Logger.getLogger(AlbumSelectHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
