/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.windows.core.table.handlers.AlbumInfoGetArtistsClickHandler;
import com.shadows.liquiblq.client.windows.core.table.handlers.ArtistInfoGetAlbumsClickHandler;
import com.shadows.liquiblq.client.windows.core.table.handlers.AlbumInfoGetSongsClickHandler;
import com.shadows.liquiblq.client.windows.core.table.handlers.SongInfoGetAlbumsClickHandler;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import com.shadows.liquiblq.data.entitys.ArtistsInAlbums;
import com.shadows.liquiblq.data.entitys.Songs;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author John
 */
public class InfomationManager {
    public static void WriteInfoAboutArtist(AnchorPane InfoPanel,Artist artist,List<Album> Albums){
        Double Margin = 27.0;
        InfoPanel.getChildren().clear();
        ((TitledPane)InfoPanel.getParent()).setText("Infomration about artist");
        CreateText("Name: "+artist.getName(), InfoPanel, Margin);
        CreateText("Nickname: "+artist.getNickname(), InfoPanel, Margin*2);
        CreateText("Date of birth: "+artist.getDateofbirth(), InfoPanel, Margin*3);
        CreateButton("View albums", new ArtistInfoGetAlbumsClickHandler(Albums), InfoPanel, Margin*4);
    }
    public static void WriteInfoAboutAlbum(AnchorPane InformationPanel, Album item) {
        Double Margin = 27.0;
        InformationPanel.getChildren().clear();
        CreateText("Name: "+item.getName(), InformationPanel, Margin);
        CreateText("Date of destribution: "+item.getDate(), InformationPanel, Margin*2);        
        CreateButton("View songs", new AlbumInfoGetSongsClickHandler(), InformationPanel, Margin*3);
        CreateButton("View artists", new AlbumInfoGetArtistsClickHandler(), InformationPanel, Margin*3);
    }

    public static void WriteInfoAboutSongs(AnchorPane InformationPanel, Songs item) {
        Double Margin = 27.0;
        InformationPanel.getChildren().clear();
        CreateText("Name: "+item.getName(), InformationPanel, Margin);
        CreateText("Date of destrubution: "+item.getDate(), InformationPanel, Margin*2);
        CreateText("Genre: "+item.getGenre(), InformationPanel, Margin*3);
        CreateButton("View albums", new SongInfoGetAlbumsClickHandler(), InformationPanel, Margin*4);
    }
    public static void CreateText(String text,AnchorPane Parent,Double Top){
        Text textObject = new Text(text);
        textObject.setLayoutY(Top);
        textObject.setVisible(true);
        textObject.setLayoutX(14.0);
        Parent.getChildren().add(textObject);
    }
    public static void CreateButton(String Text,EventHandler ClickEvent,AnchorPane Parent,Double Top){
        Button button = new Button(Text);
        button.setVisible(true);
        button.setLayoutX(14);
        button.setPrefSize(Parent.getPrefWidth() - 28, 54);
        button.setLayoutY(Top);
        button.setOnMouseClicked(ClickEvent);
        button.setVisible(true);
        Parent.getChildren().add(button);
    }

    
}
