package com.shadows.liquiblq.client.android.activities.event_listeners;

import android.view.View;
import android.widget.AdapterView;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.client.android.activities.models.AlbumListItemModel;

/**
 * Created by John on 25.4.2016 г..
 */
public class OnAlbumModelClickListener extends AOnModelItemClickListener{
    public OnAlbumModelClickListener(MainFormActivity activity) {
        super(activity);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        activity.SelectAlbum(position);
    }
}
