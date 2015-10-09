/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.windows.LiquiBLQ;
import com.shadows.liquiblq.client.windows.config.MainWindowsConfiguration;
import com.shadows.liquiblq.data.entitys.Songs;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 *
 * @author John
 */
public class DialogManager {
    public static Scene ShowDialog(Stage stage,String DialogViewName,String Title) throws IOException{
        Parent root = FXMLLoader.load(LiquiBLQ.class.getResource(DialogViewName));        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/windows/Styles.css");        
        stage.setTitle(Title);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show(); 
        return scene;
    }
    public static Scene ShowMainDialog(Stage stage) throws IOException{
        return ShowDialog(stage, "/fxml/windows/Main.fxml", "LiquiBLQ - music streaming");
    }
    public static Scene ShowLoginDialog() throws IOException{
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UNDECORATED);       
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(MainWindowsConfiguration.MainForm.getWindow());      
        return ShowDialog(dialog, "/fxml/windows/Login.fxml", "LiquiBLQ - Login/Register");                
    }
    public static Scene ShowPlaySongDialog(Songs song) throws IOException{
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UNDECORATED);       
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(MainWindowsConfiguration.MainForm.getWindow());      
        return ShowDialog(dialog, "/fxml/windows/SongPlay.fxml", "LiquiBLQ - Playsong");    
    }
}
