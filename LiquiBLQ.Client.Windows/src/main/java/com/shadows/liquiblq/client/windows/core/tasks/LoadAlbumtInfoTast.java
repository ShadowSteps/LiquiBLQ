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
import com.shadows.liquiblq.client.windows.config.MainWindowsConfiguration;
import com.shadows.liquiblq.client.windows.core.InfomationManager;
import com.shadows.liquiblq.client.windows.core.validation.controls.AlertsManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import com.shadows.liquiblq.client.windows.exceptions.UserNotLoggedInException;
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Artist;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class LoadAlbumtInfoTast extends Task<Object> {
    private final Album album;
    public LoadAlbumtInfoTast(Album album) {
        this.album = album;
    }      
    @Override
    public Object call() throws Exception {
        try{
            try{
                GetAlbumByIdResponse Response = (GetAlbumByIdResponse)RequestsManager
                    .doGetAlbumByIdRequest(
                            ConfigurationManager.GetApiUrl(),
                            LoginCredentials.getSessionKey(), 
                            LoginCredentials.GetUserId(),
                            this.album.getId()
                    );            
                InfomationManager.WriteInfoAboutAlbum(MainWindowsConfiguration.InfoPanel, this.album,Response.artists,Response.songs,MainWindowsConfiguration.MainTable);
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
