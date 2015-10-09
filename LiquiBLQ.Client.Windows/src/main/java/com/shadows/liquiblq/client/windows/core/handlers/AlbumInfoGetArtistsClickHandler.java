/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class AlbumInfoGetArtistsClickHandler implements EventHandler<Event>{
    private final List<Artist> artists;
    private final TableView table;
    private final AnchorPane InfoPane;
    
    @Override    
    public void handle(Event event) {
        TableViewManager.CreateTableFromArtists(this.table, artists,InfoPane);
    }

    public AlbumInfoGetArtistsClickHandler(List<Artist> artists,TableView table,AnchorPane InfoPane) {
        this.artists = artists;
        this.table = table;
        this.InfoPane = InfoPane;
    }

    
}
