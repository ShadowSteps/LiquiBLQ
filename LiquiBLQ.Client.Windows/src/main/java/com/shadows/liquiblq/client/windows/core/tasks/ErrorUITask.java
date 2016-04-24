/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.tasks;

import com.shadows.liquiblq.client.windows.core.DialogManager;
import com.shadows.liquiblq.client.windows.core.validation.controls.AlertsManager;
import javafx.concurrent.Task;

/**
 *
 * @author John
 */
public class ErrorUITask extends Task<Boolean>{
    private final Exception exp;

    public ErrorUITask(Exception exp) {
        this.exp = exp;
    }
    
    @Override
    protected Boolean call() throws Exception {
        DialogManager.CloseLoadingDialog();
        AlertsManager.ShowErrorAlert("Error occured!", exp.getMessage());
        return true;
    }    
}
