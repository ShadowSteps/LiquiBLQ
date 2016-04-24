/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.DialogManager;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author John
 */
public class SongPlayClickHandler implements EventHandler<Event> {
    private Song song;
    public SongPlayClickHandler(Song item) {
        this.song = item;
    }

    @Override
    public void handle(Event event) {
        try {
            DialogManager.ShowPlaySongDialog(this.song);
        } catch (IOException ex) {
            Logger.getLogger(SongPlayClickHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
