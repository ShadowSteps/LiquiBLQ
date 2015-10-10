/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.windows.config.MainWindowsConfiguration;
import com.shadows.liquiblq.client.windows.core.handlers.TableRowAlbumFactory;
import com.shadows.liquiblq.client.windows.core.handlers.TableRowArtistFactory;
import com.shadows.liquiblq.client.windows.core.handlers.TableRowSongsFactory;
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
    public static void ClearTable(){        
        MainWindowsConfiguration.MainTable.getColumns().clear();
        MainWindowsConfiguration.TableViewContainer.getChildren().remove(MainWindowsConfiguration.MainTable);
        MainWindowsConfiguration.MainTable = new TableView();
        MainWindowsConfiguration.MainTable.setPrefSize(592.0, 503.0); 
        MainWindowsConfiguration.TableViewContainer.getChildren().add(MainWindowsConfiguration.MainTable);
    }
    public static void CreateTableFromArtists(List<Artist> ObjectList){
        ClearTable();
        ArtistList.clear();
        MainWindowsConfiguration.MainTable.setRowFactory(new TableRowArtistFactory());
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
        MainWindowsConfiguration.MainTable.getColumns().addAll(IdColumn,NameColumn,NicknameColumn,DateColumn);       
        for (Artist ArtistObject : ObjectList) {
            ArtistList.add(ArtistObject);
        }
        MainWindowsConfiguration.MainTable.setItems(ArtistList);

    }

    public static void CreateTableFromAlbums(List<Album> listOfAlbums) {
        ClearTable();
        AlbumsList.clear();
        MainWindowsConfiguration.MainTable.setRowFactory(new TableRowAlbumFactory());
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
        MainWindowsConfiguration.MainTable.getColumns().addAll(IdColumn,NameColumn,DateColumn);       
        for (Album AlbumObject : listOfAlbums) {
            AlbumsList.add(AlbumObject);
        }
        MainWindowsConfiguration.MainTable.setItems(AlbumsList);

    }

    public static void CreateTableFromSongs(List<Songs> listOfSongs) {
        ClearTable();
        SongsList.clear();
        
        MainWindowsConfiguration.MainTable.setRowFactory(new TableRowSongsFactory());            
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
        MainWindowsConfiguration.MainTable.getColumns().addAll(IdColumn,NameColumn,DateColumn);       
        for (Songs AlbumObject : listOfSongs) {
            SongsList.add(AlbumObject);
        }
        MainWindowsConfiguration.MainTable.setItems(SongsList);
    }
}
