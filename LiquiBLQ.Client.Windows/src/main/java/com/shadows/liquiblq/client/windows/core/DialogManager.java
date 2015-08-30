/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.windows.LiquiBLQ;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author John
 */
public class DialogManager {
    public static void ShowDialog(Stage stage,String DialogViewName,String Title) throws IOException{
        Parent root = FXMLLoader.load(LiquiBLQ.class.getResource(DialogViewName));        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/windows/Styles.css");        
        stage.setTitle(Title);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();    
    }
    public static void ShowMainDialog(Stage stage) throws IOException{
        ShowDialog(stage, "/fxml/windows/Main.fxml", "LiquiBLQ - music streaming");
    }
    public static void ShowLoginDialog() throws IOException{
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        ShowDialog(dialog, "/fxml/windows/Login.fxml", "LiquiBLQ - Login/Register");
    }
}
