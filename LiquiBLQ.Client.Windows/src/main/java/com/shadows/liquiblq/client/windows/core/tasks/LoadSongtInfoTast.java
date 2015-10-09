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
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.getSongByIdResponse;
import com.shadows.liquiblq.data.entitys.Album;
import com.shadows.liquiblq.data.entitys.Songs;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class LoadSongtInfoTast extends Task<Object> {
    private final Songs song;
    private final AnchorPane InformationPanel;
    private final TableView table;

    public LoadSongtInfoTast(Songs song, AnchorPane InformationPanel, TableView table) {
        this.song = song;
        this.InformationPanel = InformationPanel;
        this.table = table;
    }
    
    @Override
    protected Object call() throws Exception {
        try{
            try{
                getSongByIdResponse Response = (getSongByIdResponse)RequestsManager
                    .doGetSongByIdRequest(
                            ConfigurationManager.GetApiUrl(),
                            LoginCredentials.getSessionKey(), 
                            LoginCredentials.GetUserId(),
                            this.song.getId()
                    );            
                InfomationManager.WriteInfoAboutSongs(InformationPanel, this.song,Response.getAlbums(),table);
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
