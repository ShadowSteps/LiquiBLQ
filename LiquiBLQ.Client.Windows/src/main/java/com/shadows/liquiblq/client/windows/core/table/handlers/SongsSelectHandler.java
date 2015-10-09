/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.table.handlers;

import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.data.entitys.Songs;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class SongsSelectHandler implements EventHandler {   
    private final TableRow<Songs> SongsToHandle;
    private final AnchorPane InformationPanel;
    public SongsSelectHandler(TableRow<Songs> ArtistToHandle,AnchorPane InfoPane) {
        this.SongsToHandle = ArtistToHandle;
        this.InformationPanel = InfoPane;
    }
    @Override
    public void handle(Event event) {
        if (!SongsToHandle.isEmpty()&&InformationPanel instanceof AnchorPane){
            InfomationManager.WriteInfoAboutSongs(InformationPanel, SongsToHandle.getItem());
        }
    }
    
}
