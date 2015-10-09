/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.table.handlers;

import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class ArtistSelectHandler implements EventHandler {   
    private final TableRow<Artist> ArtistToHandle;
    private final AnchorPane InformationPanel;
    private final List<Album> Artists;
    public ArtistSelectHandler(TableRow<Artist> ArtistToHandle,AnchorPane InfoPane,List<Album> Artists) {
        this.ArtistToHandle = ArtistToHandle;
        this.InformationPanel = InfoPane;
        this.Artists = Artists;
    }
    @Override
    public void handle(Event event) {
        if (!ArtistToHandle.isEmpty()&&InformationPanel instanceof AnchorPane){
            InfomationManager.WriteInfoAboutArtist(InformationPanel, ArtistToHandle.getItem(),this.Artists);
        }
    }
    
}
