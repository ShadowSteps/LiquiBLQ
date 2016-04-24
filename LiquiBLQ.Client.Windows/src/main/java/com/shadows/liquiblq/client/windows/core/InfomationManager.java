/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.windows.config.MainWindowsConfiguration;
import com.shadows.liquiblq.client.windows.core.handlers.AlbumInfoGetArtistsClickHandler;
import com.shadows.liquiblq.client.windows.core.handlers.ArtistInfoGetAlbumsClickHandler;
import com.shadows.liquiblq.client.windows.core.handlers.AlbumInfoGetSongsClickHandler;
import com.shadows.liquiblq.client.windows.core.handlers.SongInfoGetAlbumsClickHandler;
import com.shadows.liquiblq.client.windows.core.handlers.SongPlayClickHandler;
import com.shadows.liquiblq.data.interfaces.dto.Album;
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author John
 */
public class InfomationManager {
    public static void WriteInfoAboutArtist(Artist artist,List<Album> Albums){
        Double Margin = 27.0;
        MainWindowsConfiguration.InfoPanel.getChildren().clear();
        CreateText("Name: "+artist.Name, MainWindowsConfiguration.InfoPanel, Margin);
        CreateText("Nickname: "+artist.Nickname, MainWindowsConfiguration.InfoPanel, Margin*2);
        CreateText("Date of birth: "+artist.DateOfBirth, MainWindowsConfiguration.InfoPanel, Margin*3);
        CreateButton("View albums", new ArtistInfoGetAlbumsClickHandler(Albums), Margin*4);
    }
    public static void WriteInfoAboutAlbum(AnchorPane InformationPanel, Album item,List<Artist> Artists,List<Song> songs, TableView table) {
        Double Margin = 27.0;
        InformationPanel.getChildren().clear();
        CreateText("Name: "+item.Name, InformationPanel, Margin);
        CreateText("Date of destribution: "+item.PublishDate, InformationPanel, Margin*2);        
        CreateButton("View songs", new AlbumInfoGetSongsClickHandler(songs), Margin*3);
        CreateButton("View artists", new AlbumInfoGetArtistsClickHandler(Artists), Margin*5);
    }

    public static void WriteInfoAboutSongs(Song item,List<Album> Albums) {
        Double Margin = 27.0;
        MainWindowsConfiguration.InfoPanel.getChildren().clear();
        CreateText("Name: "+item.Name, MainWindowsConfiguration.InfoPanel, Margin);
        CreateText("Date of destrubution: "+item.PublishDate, MainWindowsConfiguration.InfoPanel, Margin*2);
        CreateText("Genre: "+item.Genre, MainWindowsConfiguration.InfoPanel, Margin*3);
        CreateButton("View albums", new SongInfoGetAlbumsClickHandler(Albums), Margin*4);
        CreateButton("Play song", new SongPlayClickHandler(item), Margin*6);
    }
    public static void CreateText(String text,AnchorPane Parent,Double Top){
        Text textObject = new Text(text);
        textObject.setLayoutY(Top);
        textObject.setVisible(true);
        textObject.setLayoutX(14.0);
        Parent.getChildren().add(textObject);
    }
    public static void CreateButton(String Text,EventHandler ClickEvent,Double Top){
        Button button = new Button(Text);
        button.setVisible(true);
        button.setLayoutX(14);
        button.setPrefSize(MainWindowsConfiguration.InfoPanel.getPrefWidth() - 28, 54);
        button.setLayoutY(Top);
        button.setOnMouseClicked(ClickEvent);
        button.setVisible(true);
        MainWindowsConfiguration.InfoPanel.getChildren().add(button);
    }

    
}
