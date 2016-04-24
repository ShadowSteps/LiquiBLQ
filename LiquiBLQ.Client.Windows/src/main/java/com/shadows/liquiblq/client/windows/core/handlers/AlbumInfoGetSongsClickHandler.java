/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author John
 */
public class AlbumInfoGetSongsClickHandler implements EventHandler<Event>{

    private final List<Song> songs;
    
    @Override    
    public void handle(Event event) {
        TableViewManager.CreateTableFromSongs(songs);
    }

    public AlbumInfoGetSongsClickHandler(List<Song> songs) {
        this.songs = songs;
    }
    
}
