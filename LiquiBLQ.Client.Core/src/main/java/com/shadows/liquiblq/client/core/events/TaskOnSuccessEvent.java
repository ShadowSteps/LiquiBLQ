/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.events;

/**
 *
 * @author John
 * @param <TaskResult>
 */
public class TaskOnSuccessEvent<TaskResult> implements IActionEvent{
    public TaskResult result;

    public TaskOnSuccessEvent(TaskResult result) {
        this.result = result;
    }    
}
