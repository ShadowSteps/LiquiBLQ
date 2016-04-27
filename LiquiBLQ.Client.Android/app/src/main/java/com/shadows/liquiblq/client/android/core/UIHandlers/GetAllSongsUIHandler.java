package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetAllSongsUIHandler extends AUITaskHandler<MainFormActivity, GetAllSongsResponse> {
    public GetAllSongsUIHandler(MainFormActivity activity) {
        super(activity, "Loading songs...", "Successfully loaded songs!");
    }

    @Override
    protected void OnSuccess(GetAllSongsResponse object) {
        activity.LoadSongs(object.songs);
        activity.SetTableHeader("List of songs:");
    }
}
