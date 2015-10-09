/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.data.entitys.Album;
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
public class SongInfoGetAlbumsClickHandler implements EventHandler<Event>{

    private final List<Album> albums;
    private final TableView table;
    private final AnchorPane InfoPane;
    
    @Override    
    public void handle(Event event) {
        TableViewManager.CreateTableFromAlbums(this.table, albums,InfoPane);
    }

    public SongInfoGetAlbumsClickHandler(List<Album> albums,TableView table,AnchorPane InfoPane) {
        this.albums = albums;
        this.table = table;
        this.InfoPane = InfoPane;
    }
    
}
