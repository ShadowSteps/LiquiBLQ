/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.listeners;

import com.shadows.liquiblq.client.core.events.IActionEvent;
import com.shadows.liquiblq.client.core.listeners.IActionListener;
import com.shadows.liquiblq.client.windows.core.tasks.ShowLoadingDialogTask;
import javafx.application.Platform;

/**
 *
 * @author John
 */
public class OnGetAllAlbumsStartListener implements IActionListener{

    @Override
    public void trigger(IActionEvent event) {
        Platform.runLater(new ShowLoadingDialogTask());
    }
    
}
