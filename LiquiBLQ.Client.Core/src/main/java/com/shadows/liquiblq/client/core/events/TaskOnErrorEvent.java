/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.events;

/**
 *
 * @author John
 */
public class TaskOnErrorEvent implements IActionEvent{
    public Exception error;

    public TaskOnErrorEvent(Exception err) {
        this.error = err;
    }    
}
