package com.shadows.liquiblq.client.android.core.UIHandlers.Messages;

/**
 * Created by John on 2.5.2016 г..
 */
public class SongProgressMessage {
    public String ElapsedTime;
    public String RemainingTime;
    public int Procentage;

    public SongProgressMessage(String elapsedTime, String remainingTime, int procentage) {
        ElapsedTime = elapsedTime;
        RemainingTime = remainingTime;
        Procentage = procentage;
    }
}
