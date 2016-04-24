/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.handlers;

import com.shadows.liquiblq.data.interfaces.dto.Song;
import javafx.scene.control.TableRow;
import javafx.util.Callback;

/**
 *
 * @author John
 */
public class TableRowSongsFactory implements Callback {
    @Override
    public Object call(Object param) {
        TableRow<Song> row = new TableRow<>();
        row.setOnMouseClicked(new SongsSelectHandler(row));
        return row;
    }
    
    
}
