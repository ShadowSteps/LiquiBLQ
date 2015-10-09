/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class AlbumInfoGetSongsClickHandler implements EventHandler<Event>{

    private final List<Songs> songs;
    private final TableView table;
    private final AnchorPane InfoPane;
    
    @Override    
    public void handle(Event event) {
        TableViewManager.CreateTableFromSongs(this.table, songs,InfoPane);
    }

    public AlbumInfoGetSongsClickHandler(List<Songs> songs,TableView table,AnchorPane InfoPane) {
        this.songs = songs;
        this.table = table;
        this.InfoPane = InfoPane;
    }
    
}
