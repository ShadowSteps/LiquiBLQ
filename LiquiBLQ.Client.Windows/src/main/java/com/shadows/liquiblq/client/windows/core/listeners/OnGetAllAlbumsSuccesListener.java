/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.listeners;

import com.shadows.liquiblq.client.core.events.TaskOnSuccessEvent;
import com.shadows.liquiblq.client.core.listeners.ATaskOnSuccessListener;
import com.shadows.liquiblq.client.windows.core.tasks.LoadAllAlbumsUITask;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import javafx.application.Platform;

/**
 *
 * @author John
 */
public class OnGetAllAlbumsSuccesListener extends ATaskOnSuccessListener<JSONResponse>{
    @Override
    public void onSuccess(TaskOnSuccessEvent<JSONResponse> result) {
        Platform.runLater(new LoadAllAlbumsUITask(result.result));
    }    
}
