/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.table.handlers;

import com.shadows.liquiblq.data.entitys.Artist;
import javafx.scene.control.TableRow;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

/**
 *
 * @author John
 */
public class TableRowArtistFactory implements Callback {
    private final AnchorPane InformationPanel;
    @Override
    public Object call(Object param) {
        TableRow<Artist> row = new TableRow<>();
        
        row.setOnMouseClicked(new ArtistSelectHandler(row,InformationPanel));
        return row;
    }

    public TableRowArtistFactory(AnchorPane InformationPanel) {
        this.InformationPanel = InformationPanel;
    }
    
}
