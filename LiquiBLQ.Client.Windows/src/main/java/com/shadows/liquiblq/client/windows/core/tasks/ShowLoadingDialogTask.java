/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.tasks;

import com.shadows.liquiblq.client.windows.core.DialogManager;
import javafx.concurrent.Task;

/**
 *
 * @author John
 */
public class ShowLoadingDialogTask extends Task<Boolean>{

    @Override
    protected Boolean call() throws Exception {
        DialogManager.ShowLoadingDialog();
        return true;
    }    
}
