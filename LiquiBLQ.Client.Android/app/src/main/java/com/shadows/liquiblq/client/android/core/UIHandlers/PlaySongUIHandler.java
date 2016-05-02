package com.shadows.liquiblq.client.android.core.UIHandlers;

import android.os.Handler;

import com.shadows.liquiblq.client.android.activities.PlaySongActivity;
import com.shadows.liquiblq.client.android.core.UIHandlers.Messages.SongProgressMessage;

/**
 * Created by John on 2.5.2016 г..
 */
public class PlaySongUIHandler extends Handler {
    private final PlaySongActivity activity;
    public static final int songProgress = 1;

    public PlaySongUIHandler(PlaySongActivity activity) {
        this.activity = activity;
    }

    @Override
    public void handleMessage(android.os.Message msg) {
        switch (msg.what){
            case songProgress:
                SongProgressMessage info = (SongProgressMessage) msg.obj;
                activity.ApplyProgress(info.ElapsedTime,info.RemainingTime,info.Procentage);
                break;
        }
    }
}
