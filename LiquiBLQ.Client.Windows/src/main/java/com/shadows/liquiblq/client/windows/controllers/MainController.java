/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.controllers;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import com.shadows.liquiblq.client.windows.config.AppConfig;
import com.shadows.liquiblq.client.windows.config.ConfigurationManager;
import com.shadows.liquiblq.client.windows.config.LoginCredentials;
 import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.client.windows.core.validation.controls.AlertsManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import com.shadows.liquiblq.client.windows.exceptions.UserNotLoggedInException;
import com.shadows.liquiblq.common.communication.json.artistResponse;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.control.TableView;
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
    @FXML
    private Text LoginTextButton;
    @FXML
    private AnchorPane MainPane;
    @FXML
    private TableView mainTable;
    @Override
    public void initialize(URL url, ResourceBundle rb) {                          
    }    
    
    @FXML
    private void menuExitItemClick(){
        Platform.exit();
    }
    @FXML
    private void fetchAllArtists(){
        try {
           AppConfig conf = ConfigurationManager.GetApplicationConfiguration();
           String ApiUrl = conf.getApiUrl();
           try {
                artistResponse Response = (artistResponse)RequestsManager.doGetAllArtistsRequest(
                       ApiUrl, 
                       LoginCredentials.getSessionKey(), 
                       LoginCredentials.GetUserId()
                );           
                TableViewManager.CrateTableFromArtists(mainTable, Response.getListOfArtists());
           } catch (HttpRequestErrorException ex) {
               AlertsManager.ShowErrorAlert("Server not responding","Our attempt to make a request to the server has failed! Please try again later!");
           } catch (CannotParseResponseException ex) {
               AlertsManager.ShowErrorAlert("Internal server error","The response of the server was invalid! Please try again later!");
           } catch (UserNotLoggedInException ex) {
                AlertsManager.ShowErrorAlert("Application error","User must be logged in to access options!");
                Platform.exit();
            }
       } catch (ApplicationConfigurationException ex) {
           AlertsManager.ShowErrorAlert("Invalid client configuration","Your client was not configured porperly!Please reinstall");
       }
    }
    @FXML
    private void fetchAllAlbums(){
        
    }
    @FXML
    private void fetchAllSongs(){
        
    }
}
