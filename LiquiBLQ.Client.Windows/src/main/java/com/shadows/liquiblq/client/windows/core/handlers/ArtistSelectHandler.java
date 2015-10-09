/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.client.windows.core.tasks.LoadArtistInfoTast;
import com.shadows.liquiblq.data.entitys.Artist;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class ArtistSelectHandler implements EventHandler {   
    private final TableRow<Artist> ArtistToHandle;
    private final AnchorPane InformationPanel;
    private final TableView table;

    public ArtistSelectHandler(TableRow<Artist> ArtistToHandle, AnchorPane InformationPanel, TableView table) {
        this.ArtistToHandle = ArtistToHandle;
        this.InformationPanel = InformationPanel;
        this.table = table;
    }
    
    @Override
    public void handle(Event event) {
        if (!ArtistToHandle.isEmpty()&&InformationPanel instanceof AnchorPane){
            LoadArtistInfoTast task = new LoadArtistInfoTast(ArtistToHandle.getItem(), InformationPanel,table);
            task.run();
        }
    }
    
}
