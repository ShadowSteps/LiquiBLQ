/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.tasks;

import com.shadows.liquiblq.client.core.events.TaskOnErrorEvent;
import com.shadows.liquiblq.client.core.events.TaskOnSuccessEvent;
import com.shadows.liquiblq.client.core.listeners.ATaskOnErrorListener;
import com.shadows.liquiblq.client.core.listeners.ATaskOnSuccessListener;
import com.shadows.liquiblq.client.core.listeners.IActionListener;

/**
 *
 * @author John
 * @param <ReturnType>
 */
public abstract class RunnableTask<ReturnType> implements Runnable{
    public IActionListener onStart;
    public ATaskOnErrorListener onError;
    public ATaskOnSuccessListener<ReturnType> onSuccess;
    private ReturnType lastResult = null;
    private Exception lastError = null;
    
    public ReturnType get() throws Exception{
        if (lastResult!=null&&lastError==null)
            return lastResult;
        if (lastError!=null)
            throw lastError;
        return null;
    }
    
    @Override
    public void run() {
        if (onStart!=null)
            onStart.trigger(null);
        try {
            this.lastResult = doRoutine();
            if (onSuccess!=null)
                onSuccess.trigger(new TaskOnSuccessEvent(this.lastResult));
        } 
        catch (Exception exp){
            this.lastError = exp;
            if (onError!=null)
                onError.trigger(new TaskOnErrorEvent(lastError));
        }
    }
    
    protected abstract ReturnType doRoutine() throws Exception;
}
