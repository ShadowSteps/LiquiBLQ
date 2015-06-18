/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.controllers;

import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author John
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private MenuBar MainMenuBar;
    @FXML
    private MenuItem MainMenuExitMenuItem;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void menuExitItemClick(){
        Platform.exit();
    }
    
}
