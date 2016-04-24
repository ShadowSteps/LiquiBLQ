package com.shadows.liquiblq.client.android.core.tasks.listeners;

import android.os.Message;

import com.shadows.liquiblq.client.android.core.UIHandlers.AUITaskHandler;
import com.shadows.liquiblq.client.core.events.IActionEvent;
import com.shadows.liquiblq.client.core.listeners.IActionListener;

/**
 * Created by John on 24.4.2016 г..
 */
public class TaskStartListener<THandler extends AUITaskHandler> implements IActionListener {
    private final THandler handler;

    public TaskStartListener(THandler handler) {
        this.handler = handler;
    }
    @Override
    public void trigger(IActionEvent iActionEvent) {
        Message message = handler.obtainMessage(THandler.startProcessState, null);
        message.sendToTarget();
    }
}