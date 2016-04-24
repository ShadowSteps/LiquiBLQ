package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.widget.AdapterView;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;

/**
 * Created by John on 25.4.2016 г..
 */
public abstract class AOnModelItemClickListener implements AdapterView.OnItemClickListener{
    protected final MainFormActivity activity;
    public AOnModelItemClickListener(MainFormActivity activity){
        this.activity = activity;
    }
}
