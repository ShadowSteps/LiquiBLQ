package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.view.MenuItem;
import android.view.View;

import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsOfArtistUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetArtistsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;

import java.util.UUID;

/**
 * Created by John on 27.4.2016 г..
 */
public class OnArtistGetAlbumsClickListener extends AOnInfoButtonClickListener<GetAlbumsOfArtistUIHandler> {
    public OnArtistGetAlbumsClickListener(TasksManager manager, UUID id, GetAlbumsOfArtistUIHandler handler) {
        super(manager, id, handler);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        manager.StartGetAlbumsOfArtistTask(handler, LoginSession.sessionKey, LoginSession.UserId, ObjectId);
        return true;
    }
}
