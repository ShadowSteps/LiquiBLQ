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
import com.shadows.liquiblq.data.interfaces.dto.Artist;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author John
 */
public class LoadArtistInfoTast extends Task<Object> {
    private final Artist artist;
    public LoadArtistInfoTast(Artist artist) {
        this.artist = artist;
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
                            this.artist.Id
                    );            
                InfomationManager.WriteInfoAboutArtist( this.artist,Response.albums);
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
