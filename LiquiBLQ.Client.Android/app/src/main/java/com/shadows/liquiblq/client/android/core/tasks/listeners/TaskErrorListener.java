package com.shadows.liquiblq.client.android.core.tasks.listeners;

import android.os.Message;

import com.shadows.liquiblq.client.android.core.UIHandlers.AUITaskHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.RegisterUIHandler;
import com.shadows.liquiblq.client.core.events.TaskOnErrorEvent;
import com.shadows.liquiblq.client.core.listeners.ATaskOnErrorListener;

/**
 * Created by John on 24.4.2016 г..
 */
public class TaskErrorListener<THandler extends AUITaskHandler> extends ATaskOnErrorListener {
    private final THandler handler;

    public TaskErrorListener(THandler handler) {
        this.handler = handler;
    }
    @Override
    public void onError(TaskOnErrorEvent taskOnErrorEvent) {
        Message message = handler.obtainMessage(THandler.errorOnRegistrationState,taskOnErrorEvent.error);
        message.sendToTarget();
    }
}
