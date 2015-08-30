/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.controllers;

import com.shadows.liquiblq.client.exceptions.ControllerNotConfiguredException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author John
 */
public class LoginController implements Initializable{

    @FXML
    private TabPane loginTabsPanel;    
    
    @FXML
    private AnchorPane MainPanel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO: Initialization
    }
    
    protected void resizeStage(){
        Stage stage = (Stage)MainPanel.getScene().getWindow();
        stage.sizeToScene();
    }
    @FXML
    private void registerTabActive(){
        MainPanel.resize(308, 376);
        resizeStage();
    }
    
    @FXML
    private void loginTabActive() throws ControllerNotConfiguredException{
        MainPanel.resize(308, 188);
        resizeStage();
    }
}
