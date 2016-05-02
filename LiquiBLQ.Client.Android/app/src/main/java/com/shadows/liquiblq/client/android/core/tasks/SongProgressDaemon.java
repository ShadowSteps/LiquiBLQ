package com.shadows.liquiblq.client.android.core.tasks;

import android.media.MediaPlayer;
import android.os.Message;

import com.shadows.liquiblq.client.android.activities.PlaySongActivity;
import com.shadows.liquiblq.client.android.config.Formats;
import com.shadows.liquiblq.client.android.core.UIHandlers.Messages.SongProgressMessage;
import com.shadows.liquiblq.client.android.core.UIHandlers.PlaySongUIHandler;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by John on 2.5.2016 г..
 */
public class SongProgressDaemon implements Runnable {
    private final MediaPlayer player;
    private PlaySongUIHandler uiHandler;
    public boolean isRunning = true;

    public SongProgressDaemon(MediaPlayer player, PlaySongActivity activity) {
        this.player = player;
        this.uiHandler = new PlaySongUIHandler(activity);
    }

    @Override
    public void run() {
        while (isRunning&&player!=null){
            long songDuration = player.getDuration();
            long currentDuration = player.getCurrentPosition();
            long songMins = TimeUnit.MILLISECONDS.toMinutes(songDuration);
            long songSecs = TimeUnit.MILLISECONDS.toSeconds(songDuration) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(songDuration));
            long currentMins = TimeUnit.MILLISECONDS.toMinutes(currentDuration);
            long currentSecs = TimeUnit.MILLISECONDS.toSeconds(currentDuration) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentDuration));
            String current = String.format("%02d:%02d",
                    currentMins,
                    currentSecs
            );
            long elapsedSecs = (songMins * 60 + songSecs) - (currentMins * 60 + currentSecs);
            String elapsed = String.format("%02d:%02d",
                    TimeUnit.SECONDS.toMinutes(elapsedSecs),
                    TimeUnit.SECONDS.toSeconds(elapsedSecs) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(elapsedSecs))
            );
            float progressLong = (float)(currentMins * 60 + currentSecs) / (float)(songMins * 60 + songSecs) ;
            int progress = (int) Math.floor( progressLong * 100 );
            Message msg = uiHandler.obtainMessage(PlaySongUIHandler.songProgress,new SongProgressMessage(elapsed,current,progress));
            msg.sendToTarget();
        }
    }
}
