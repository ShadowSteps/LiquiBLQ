package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.view.View;
import android.widget.AdapterView;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;

/**
 * Created by John on 25.4.2016 г..
 */
public class OnSongModelClickListener extends AOnModelItemClickListener{
    public OnSongModelClickListener(MainFormActivity activity) {
        super(activity);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        activity.SelectSong(position);
    }
}
