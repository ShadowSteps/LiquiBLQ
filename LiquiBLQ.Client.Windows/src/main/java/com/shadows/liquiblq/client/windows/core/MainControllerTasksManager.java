/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core;

import com.shadows.liquiblq.client.core.tasks.GetAllAlbumsTask;
import com.shadows.liquiblq.client.windows.core.listeners.OnGetAllAlbumsErrorListener;
import com.shadows.liquiblq.client.windows.core.listeners.OnGetAllAlbumsStartListener;
import com.shadows.liquiblq.client.windows.core.listeners.OnGetAllAlbumsSuccesListener;
import java.util.UUID;

/**
 *
 * @author John
 */
public class MainControllerTasksManager {
    public void RunGetAllAlbumsTask(String ApiUrl, UUID SessionKey, Integer Id){
        GetAllAlbumsTask task = new GetAllAlbumsTask(ApiUrl, SessionKey, Id);
        task.onSuccess = new OnGetAllAlbumsSuccesListener();
        task.onStart = new OnGetAllAlbumsStartListener();
        task.onError = new OnGetAllAlbumsErrorListener();
        new Thread(task).start();
    }
}
