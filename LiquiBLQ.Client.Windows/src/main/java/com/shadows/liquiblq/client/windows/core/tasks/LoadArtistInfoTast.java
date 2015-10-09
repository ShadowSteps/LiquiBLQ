/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.tasks;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import com.shadows.liquiblq.client.windows.config.ConfigurationManager;
import com.shadows.liquiblq.client.windows.config.LoginCredentials;
import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.client.windows.core.validation.controls.AlertsManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import com.shadows.liquiblq.client.windows.exceptions.UserNotLoggedInException;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.data.entitys.Artist;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class LoadArtistInfoTast extends Task<Object> {
    private final Artist artist;
    private final AnchorPane InformationPanel;
    private final TableView table;

    public LoadArtistInfoTast(Artist artist, AnchorPane InformationPanel, TableView table) {
        this.artist = artist;
        this.InformationPanel = InformationPanel;
        this.table = table;
    }
       
    
    @Override
    protected Object call() throws Exception {
        try{
            try{
                GetArtistByIdResponse Response = (GetArtistByIdResponse)RequestsManager
                    .doGetArtistByIdRequest(
                            ConfigurationManager.GetApiUrl(),
                            LoginCredentials.getSessionKey(), 
                            LoginCredentials.GetUserId(),
                            this.artist.getId()
                    );            
                InfomationManager.WriteInfoAboutArtist(InformationPanel, this.artist,Response.getAlbums(),table);
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
        return Boolean.TRUE;
    }    
}
