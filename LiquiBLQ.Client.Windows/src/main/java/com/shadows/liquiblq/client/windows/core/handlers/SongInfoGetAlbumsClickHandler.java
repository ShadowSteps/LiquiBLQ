/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author John
 */
public class SongInfoGetAlbumsClickHandler implements EventHandler<Event>{

    private final List<Album> albums;
    
    @Override    
    public void handle(Event event) {
        TableViewManager.CreateTableFromAlbums(albums);
    }

    public SongInfoGetAlbumsClickHandler(List<Album> albums) {
        this.albums = albums;
    }
    
}
