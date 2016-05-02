package com.shadows.liquiblq.client.android.activities;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.shadows.liquiblq.client.android.R;
import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.managers.DialogManager;
import com.shadows.liquiblq.client.android.core.tasks.SongProgressDaemon;
import com.shadows.liquiblq.client.core.SongsRequestsHandler;
import com.shadows.liquiblq.data.interfaces.dto.Song;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.UUID;

public class PlaySongActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    private UUID SongId;
    private MediaPlayer mediaPlayer;
    private TextView elapsedText;
    private TextView remainingText;
    private SeekBar progressBar;
    private SongProgressDaemon daemon;

    public void LoadSong(){
        Intent intent = getIntent();
        SongId = UUID.fromString(intent.getStringExtra("SongId"));
        String SongName = intent.getStringExtra("SongName");
        TextView songNameView = (TextView)findViewById(R.id.textView2);
        songNameView.setText("Now Playing: "+SongName);
        doPlaySong(findViewById(R.id.SongPlay));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        elapsedText = (TextView)findViewById(R.id.currentSongElapsed);
        remainingText = (TextView)findViewById(R.id.songRemaining);
        progressBar = (SeekBar)findViewById(R.id.seekBar);
        LoadSong();
    }

    @Override
    public void onBackPressed() {
    }

    private void stopPlayerIfStarted(){
        if (mediaPlayer != null){
            daemon.isRunning = false;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void doPlaySong(View sender){
        if (mediaPlayer != null && !mediaPlayer.isPlaying()){
            mediaPlayer.start();
        } else {
            stopPlayerIfStarted();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(
                        SongsRequestsHandler.getStreamMusicUrl(getString(R.string.api_url), LoginSession.sessionKey,LoginSession.UserId, SongId)
                );
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.setOnErrorListener(this);
                mediaPlayer.setOnCompletionListener(this);
                mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
                mediaPlayer.prepareAsync();
                DialogManager.ShowLoadingDialog(this,"Buffering....");
            } catch (IOException e) {
                AlertManager.ShowErrorAlert(this, "Could not find song!");
            }
        }
    }

    public void doPauseSong(View sender){
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void doStopSong(View sender){
        if (mediaPlayer != null){
           stopPlayerIfStarted();
        }
        finish();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        DialogManager.CloseLoadingDialog();
        mp.start();
        daemon = new SongProgressDaemon(mp,this);
        new Thread(daemon).start();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        DialogManager.CloseLoadingDialog();
        AlertManager.ShowErrorAlert(this, "Could not play song!");
        stopPlayerIfStarted();
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
        stopPlayerIfStarted();
    }

    public void ApplyProgress(String elapsed, String remaining, int procent){
        progressBar.setProgress(procent);
        elapsedText.setText(elapsed);
        remainingText.setText(remaining);
    }
}
