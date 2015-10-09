/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.data.entitys.Artist;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author John
 */
public class TableViewManager {
    private static final ObservableList<Artist> ArtistList =
        FXCollections.observableArrayList();
    public static void ClearTable(TableView Table){        
        Table.getColumns().clear();
    }
    public static void CrateTableFromArtists(TableView View,List<Artist> ObjectList){
        ClearTable(View);
        ArtistList.clear();
        TableColumn IdColumn = new TableColumn("Id"),
                NameColumn = new TableColumn("Name"),
                NicknameColumn = new TableColumn("Nickname"),
                DateColumn = new TableColumn("Date of Birth");
        IdColumn.setCellValueFactory(
            new PropertyValueFactory<Artist, UUID>("id")
        );
        NameColumn.setCellValueFactory(
            new PropertyValueFactory<Artist, String>("name")
        );
        NicknameColumn.setCellValueFactory(
            new PropertyValueFactory<Artist, String>("nickname")
        );
        DateColumn.setCellValueFactory(
            new PropertyValueFactory<Artist, Date>("dateofbirth")
        );
        View.getColumns().addAll(IdColumn,NameColumn,NicknameColumn,DateColumn);       
        for (Artist ArtistObject : ObjectList) {
            ArtistList.add(ArtistObject);
        }
        View.setItems(ArtistList);
    }
}
