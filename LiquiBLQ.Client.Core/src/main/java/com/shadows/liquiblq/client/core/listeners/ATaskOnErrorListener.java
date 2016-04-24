/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.listeners;

import com.shadows.liquiblq.client.core.events.IActionEvent;
import com.shadows.liquiblq.client.core.events.TaskOnErrorEvent;

/**
 *
 * @author John
 */
public abstract class ATaskOnErrorListener implements IActionListener{
    @Override
    public void trigger(IActionEvent event) {
        TaskOnErrorEvent e = (TaskOnErrorEvent)event;
        this.onError(e);
    }
    
    public abstract void onError(TaskOnErrorEvent result);
}
