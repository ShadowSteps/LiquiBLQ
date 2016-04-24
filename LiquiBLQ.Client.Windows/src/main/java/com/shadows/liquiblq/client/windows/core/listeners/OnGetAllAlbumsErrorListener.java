/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.listeners;

import com.shadows.liquiblq.client.core.events.TaskOnErrorEvent;
import com.shadows.liquiblq.client.core.listeners.ATaskOnErrorListener;
import com.shadows.liquiblq.client.windows.core.tasks.ErrorUITask;
import javafx.application.Platform;

/**
 *
 * @author John
 */
public class OnGetAllAlbumsErrorListener extends ATaskOnErrorListener{

    @Override
    public void onError(TaskOnErrorEvent result) {
        Exception exp = result.error;
        Platform.runLater(new ErrorUITask(exp));
    }
}
