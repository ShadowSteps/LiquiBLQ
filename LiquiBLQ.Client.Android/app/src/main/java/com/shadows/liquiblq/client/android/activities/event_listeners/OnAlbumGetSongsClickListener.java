package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.view.MenuItem;
import android.view.View;

import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetSongsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;

import java.util.UUID;

/**
 * Created by John on 27.4.2016 г..
 */
public class OnAlbumGetSongsClickListener extends AOnInfoButtonClickListener<GetSongsInAlbumUIHandler> {

    public OnAlbumGetSongsClickListener(TasksManager manager, UUID id, GetSongsInAlbumUIHandler handler) {
        super(manager, id, handler);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        manager.StartGetSongsInAlbumTask(handler, LoginSession.sessionKey,LoginSession.UserId,ObjectId);
        return true;
    }
}
