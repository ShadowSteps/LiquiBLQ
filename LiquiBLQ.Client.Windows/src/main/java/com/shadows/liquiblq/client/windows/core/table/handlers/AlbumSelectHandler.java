/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.table.handlers;

import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.data.entitys.Album;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class AlbumSelectHandler implements EventHandler {   
    private final TableRow<Album> AlbumToHandle;
    private final AnchorPane InformationPanel;
    public AlbumSelectHandler(TableRow<Album> ArtistToHandle,AnchorPane InfoPane) {
        this.AlbumToHandle = ArtistToHandle;
        this.InformationPanel = InfoPane;
    }
    @Override
    public void handle(Event event) {
        if (!AlbumToHandle.isEmpty()&&InformationPanel instanceof AnchorPane){
            InfomationManager.WriteInfoAboutAlbum(InformationPanel, AlbumToHandle.getItem());
        }
    }
    
}
