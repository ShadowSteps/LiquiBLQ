/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.config.MainWindowsConfiguration;
import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.data.entitys.Album;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class ArtistInfoGetAlbumsClickHandler implements EventHandler<Event>{
    private final List<Album> Albums;
    @Override
    
    public void handle(Event event) {
        TableViewManager.CreateTableFromAlbums(Albums);
    }

    public ArtistInfoGetAlbumsClickHandler(List<Album> Albums) {
        this.Albums = Albums;
    }
    
}
