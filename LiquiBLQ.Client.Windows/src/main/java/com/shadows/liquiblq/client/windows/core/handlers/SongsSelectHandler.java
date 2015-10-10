/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.client.windows.core.tasks.LoadSongtInfoTast;
import com.shadows.liquiblq.data.entitys.Songs;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class SongsSelectHandler implements EventHandler {   
    private final TableRow<Songs> SongsToHandle;

    public SongsSelectHandler(TableRow<Songs> SongsToHandle) {
        this.SongsToHandle = SongsToHandle;
    }
    
    
    @Override
    public void handle(Event event) {
        if (!SongsToHandle.isEmpty()){
            LoadSongtInfoTast task = new LoadSongtInfoTast(this.SongsToHandle.getItem());
            task.run();
        }
    }
    
}
