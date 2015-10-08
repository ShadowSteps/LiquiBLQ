/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.controls;

import javafx.scene.control.Alert;

/**
 *
 * @author John
 */
public class AlertsManager {
    public static void ShowErrorAlert(String Title,String Text){
        Alert alert = new Alert(Alert.AlertType.ERROR);   
        alert.setTitle(Title);
        alert.setContentText(Text);
        alert.show();
    }
    public static void ShowInfoAlert(String Title,String Text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);   
        alert.setTitle(Title);
        alert.setContentText(Text);
        alert.show();
    }
}
