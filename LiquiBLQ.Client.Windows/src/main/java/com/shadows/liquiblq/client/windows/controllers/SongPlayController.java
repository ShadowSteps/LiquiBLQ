package com.shadows.liquiblq.client.windows.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.shadows.liquiblq.client.windows.config.ConfigurationManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * FXML Controller class
 *
 * @author John
 */
public class SongPlayController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void PlaySong(Song songToPlay) throws ApplicationConfigurationException{
        String song = ConfigurationManager.GetApiUrl()+"Song/Play/"+songToPlay.Id.toString();
        Player mp3player = null;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new URL(song).openStream());
            mp3player = new Player(in);
            mp3player.play();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (JavaLayerException | NullPointerException  e) {
        }
    }
    
}
