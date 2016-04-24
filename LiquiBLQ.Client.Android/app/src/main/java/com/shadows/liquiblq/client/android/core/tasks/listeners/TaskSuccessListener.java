package com.shadows.liquiblq.client.android.core.tasks.listeners;

import android.os.Message;

import com.shadows.liquiblq.client.android.core.UIHandlers.AUITaskHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.RegisterUIHandler;
import com.shadows.liquiblq.client.core.events.TaskOnSuccessEvent;
import com.shadows.liquiblq.client.core.listeners.ATaskOnSuccessListener;
import com.shadows.liquiblq.common.communication.json.JSONResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class TaskSuccessListener<THandler extends AUITaskHandler> extends ATaskOnSuccessListener<JSONResponse> {
    private final THandler handler;

    public TaskSuccessListener(THandler handler) {
        this.handler = handler;
    }
    @Override
    public void onSuccess(TaskOnSuccessEvent<JSONResponse> taskOnSuccessEvent) {
        Message message = handler.obtainMessage(THandler.successfulRegistrationState,taskOnSuccessEvent.result);
        message.sendToTarget();
    }
}
