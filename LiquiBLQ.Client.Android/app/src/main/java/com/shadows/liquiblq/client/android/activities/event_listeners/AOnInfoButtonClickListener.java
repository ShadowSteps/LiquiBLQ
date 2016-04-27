package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.view.MenuItem;
import android.view.View;

import com.shadows.liquiblq.client.android.core.UIHandlers.AUITaskHandler;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;

import java.util.UUID;

/**
 * Created by John on 27.4.2016 г..
 */
public abstract class AOnInfoButtonClickListener<THandler extends AUITaskHandler> implements MenuItem.OnMenuItemClickListener {
    protected final TasksManager manager;
    protected final THandler handler;
    protected final UUID ObjectId;

    public AOnInfoButtonClickListener(TasksManager manager, UUID id, THandler handler) {
        this.manager = manager;
        ObjectId = id;
        this.handler = handler;
    }
}
