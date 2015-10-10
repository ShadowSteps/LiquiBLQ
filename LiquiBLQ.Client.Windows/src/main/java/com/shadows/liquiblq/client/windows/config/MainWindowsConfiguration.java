/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.config;

import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class MainWindowsConfiguration {
    public static Scene MainForm;
    public static TableView MainTable;
    public static AnchorPane TableViewContainer;
    public static TableView MainTableSongs;
    public static AnchorPane InfoPanel;

    public static Scene getMainForm() throws ApplicationConfigurationException {
        if (!(MainForm instanceof Scene)){
            throw new ApplicationConfigurationException("MainForm not loaded into configuration!");
        }
        return MainForm;
    }

    public static void setMainForm(Scene MainForm) {        
        MainWindowsConfiguration.MainForm = MainForm;
    }

    public static TableView getMainTable() throws ApplicationConfigurationException {
        if (!(MainTable instanceof TableView)){
            throw new ApplicationConfigurationException("MainTable not loaded into configuration!");
        }
        return MainTable;
    }

    public static void setMainTable(TableView MainTable) {
        MainWindowsConfiguration.MainTable = MainTable;
    }

    public static AnchorPane getInfoPanel() throws ApplicationConfigurationException {
        if (!(InfoPanel instanceof AnchorPane)){
            throw new ApplicationConfigurationException("InfoPanel not loaded into configuration!");
        }
        return InfoPanel;
    }

    public static void setInfoPanel(AnchorPane InfoPanel) {
        MainWindowsConfiguration.InfoPanel = InfoPanel;
    }

    public MainWindowsConfiguration() {
    }

    
    
}
