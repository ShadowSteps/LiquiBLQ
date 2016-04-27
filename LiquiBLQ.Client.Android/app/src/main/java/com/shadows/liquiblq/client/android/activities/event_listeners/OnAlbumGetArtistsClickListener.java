package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.view.MenuItem;
import android.view.View;

import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetArtistsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;

import java.util.UUID;

/**
 * Created by John on 27.4.2016 г..
 */
public class OnAlbumGetArtistsClickListener extends AOnInfoButtonClickListener<GetArtistsInAlbumUIHandler> {
    public OnAlbumGetArtistsClickListener(TasksManager manager, UUID id, GetArtistsInAlbumUIHandler handler) {
        super(manager, id, handler);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        manager.StartGetArtistsInAlbumTask(handler, LoginSession.sessionKey, LoginSession.UserId, ObjectId);
        return true;
    }
}
