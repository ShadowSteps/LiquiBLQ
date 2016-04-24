/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.tasks;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.client.windows.config.ConfigurationManager;
import com.shadows.liquiblq.client.windows.config.LoginCredentials;
import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.client.windows.core.validation.controls.AlertsManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import com.shadows.liquiblq.client.windows.exceptions.UserNotLoggedInException;
import com.shadows.liquiblq.common.communication.json.GetSongByIdResponse;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author John
 */
public class LoadSongtInfoTast extends Task<Object> {
    private final Song song;

    public LoadSongtInfoTast(Song song) {
        this.song = song;
    }
    
    @Override
    protected Object call() throws Exception {
        try{
            try{
                GetSongByIdResponse Response = (GetSongByIdResponse)RequestsManager
                    .doGetSongByIdRequest(
                            ConfigurationManager.GetApiUrl(),
                            LoginCredentials.getSessionKey(), 
                            LoginCredentials.GetUserId(),
                            this.song.Id
                    );            
                InfomationManager.WriteInfoAboutSongs(this.song,Response.albums);
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
