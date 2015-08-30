/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.controllers;

import com.shadows.liquiblq.client.windows.exceptions.ControllerNotConfiguredException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField RegisterEmail;
    @FXML
    private TextField LoginEmail;
    @FXML
    private TextField RegisterName;
    @FXML
    private PasswordField RegisterPassword;
    @FXML
    private PasswordField RegisterRepeatPassword;
    @FXML
    private PasswordField LoginPassword;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO: Initialization
    }
    
    protected void resizeStage(){
        Stage stage = (Stage)MainPanel.getScene().getWindow();
        stage.sizeToScene();
    }
    
    @FXML
    private void onRegisterButtonClick(){
        
    }
}
