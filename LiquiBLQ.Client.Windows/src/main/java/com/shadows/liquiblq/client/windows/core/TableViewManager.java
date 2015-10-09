/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.windows.core.table.handlers.TableRowAlbumFactory;
import com.shadows.liquiblq.client.windows.core.table.handlers.TableRowArtistFactory;
import com.shadows.liquiblq.client.windows.core.table.handlers.TableRowSongsFactory;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class TableViewManager {
    private static final ObservableList<Artist> ArtistList =
        FXCollections.observableArrayList();
    private static final ObservableList<Album> AlbumsList =
        FXCollections.observableArrayList();
    private static final ObservableList<Songs> SongsList =
        FXCollections.observableArrayList();
    public static void ClearTable(TableView Table){        
        Table.getColumns().clear();
    }
    public static void CrateTableFromArtists(TableView View,List<Artist> ObjectList,AnchorPane InfoPane){
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
        
        View.setRowFactory(new TableRowArtistFactory(InfoPane));
    }

    public static void CrateTableFromAlbums(TableView mainTable, List<Album> listOfAlbums,AnchorPane InfoPane) {
        ClearTable(mainTable);
        AlbumsList.clear();
        TableColumn IdColumn = new TableColumn("Id"),
                NameColumn = new TableColumn("Name"),
                DateColumn = new TableColumn("Date of destribution");
        IdColumn.setCellValueFactory(
            new PropertyValueFactory<Album, UUID>("id")
        );
        NameColumn.setCellValueFactory(
            new PropertyValueFactory<Album, String>("name")
        );
        DateColumn.setCellValueFactory(
            new PropertyValueFactory<Album, Date>("date")
        );
        mainTable.getColumns().addAll(IdColumn,NameColumn,DateColumn);       
        for (Album AlbumObject : listOfAlbums) {
            AlbumsList.add(AlbumObject);
        }
        mainTable.setItems(AlbumsList);
        mainTable.setRowFactory(new TableRowAlbumFactory(InfoPane));
    }

    public static void CrateTableFromSongs(TableView mainTable, List<Songs> listOfSongs,AnchorPane InfoPane) {
        ClearTable(mainTable);
        SongsList.clear();
        TableColumn IdColumn = new TableColumn("Id"),
                NameColumn = new TableColumn("Name"),
                GenreColumn = new TableColumn("Genre"),
                DateColumn = new TableColumn("Date of destribution");
        IdColumn.setCellValueFactory(
            new PropertyValueFactory<Songs, UUID>("id")
        );
        NameColumn.setCellValueFactory(
            new PropertyValueFactory<Songs, String>("name")
        );
        GenreColumn.setCellValueFactory(
            new PropertyValueFactory<Songs, UUID>("genre")
        );
        DateColumn.setCellValueFactory(
            new PropertyValueFactory<Songs, Date>("date")
        );
        mainTable.getColumns().addAll(IdColumn,NameColumn,DateColumn);       
        for (Songs AlbumObject : listOfSongs) {
            SongsList.add(AlbumObject);
        }
        mainTable.setItems(SongsList);
        mainTable.setRowFactory(new TableRowSongsFactory(InfoPane));
    }
}
