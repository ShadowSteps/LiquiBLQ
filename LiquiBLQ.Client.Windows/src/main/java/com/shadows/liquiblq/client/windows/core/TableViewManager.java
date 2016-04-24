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
import com.shadows.liquiblq.client.windows.core.models.AlbumTableViewModel;
import com.shadows.liquiblq.client.windows.core.models.ArtistTableViewModel;
import com.shadows.liquiblq.client.windows.core.models.SongTableViewModel;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.Song;
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
    private static final ObservableList<ArtistTableViewModel> ArtistList =
        FXCollections.observableArrayList();
    private static final ObservableList<AlbumTableViewModel> AlbumsList =
        FXCollections.observableArrayList();
    private static final ObservableList<SongTableViewModel> SongsList =
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
            new PropertyValueFactory<ArtistTableViewModel, UUID>("Id")
        );
        NameColumn.setCellValueFactory(
            new PropertyValueFactory<ArtistTableViewModel, String>("Name")
        );
        NicknameColumn.setCellValueFactory(
            new PropertyValueFactory<ArtistTableViewModel, String>("Nickname")
        );
        DateColumn.setCellValueFactory(
            new PropertyValueFactory<ArtistTableViewModel, Date>("DateOfBirth")
        );
        MainWindowsConfiguration.MainTable.getColumns().addAll(IdColumn,NameColumn,NicknameColumn,DateColumn);       
        for (Artist ArtistObject : ObjectList) {
            ArtistList.add(ArtistTableViewModel.FromDTO(ArtistObject));
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
            new PropertyValueFactory<AlbumTableViewModel, UUID>("Id")
        );
        NameColumn.setCellValueFactory(
            new PropertyValueFactory<AlbumTableViewModel, String>("Name")
        );
        DateColumn.setCellValueFactory(
            new PropertyValueFactory<AlbumTableViewModel, Date>("PublishDate")
        );
        MainWindowsConfiguration.MainTable.getColumns().addAll(IdColumn,NameColumn,DateColumn);       
        for (Album AlbumObject : listOfAlbums) {
            AlbumsList.add(AlbumTableViewModel.FromDTO(AlbumObject));
        }
        MainWindowsConfiguration.MainTable.setItems(AlbumsList);

    }

    public static void CreateTableFromSongs(List<Song> listOfSongs) {
        ClearTable();
        SongsList.clear();
        
        MainWindowsConfiguration.MainTable.setRowFactory(new TableRowSongsFactory());            
        TableColumn IdColumn = new TableColumn("Id"),
                NameColumn = new TableColumn("Name"),
                GenreColumn = new TableColumn("Genre"),
                DateColumn = new TableColumn("Date of destribution");
        IdColumn.setCellValueFactory(
            new PropertyValueFactory<SongTableViewModel, UUID>("Id")
        );
        NameColumn.setCellValueFactory(
            new PropertyValueFactory<SongTableViewModel, String>("Name")
        );
        GenreColumn.setCellValueFactory(
            new PropertyValueFactory<SongTableViewModel, String>("GenreName")
        );
        DateColumn.setCellValueFactory(
            new PropertyValueFactory<SongTableViewModel, Date>("PublishDate")
        );
        MainWindowsConfiguration.MainTable.getColumns().addAll(IdColumn,NameColumn,DateColumn);       
        for (Song AlbumObject : listOfSongs) {
            SongsList.add(SongTableViewModel.FromDTO(AlbumObject));
        }
        MainWindowsConfiguration.MainTable.setItems(SongsList);
    }
}
