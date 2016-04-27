package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfArtistResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfSongResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetAlbumsOfSongUIHandler extends AUITaskHandler<MainFormActivity, GetAlbumsOfSongResponse> {
    public GetAlbumsOfSongUIHandler(MainFormActivity activity) {
        super(activity, "Loading Albums", "Successfully loaded albums!");
    }

    @Override
    protected void OnSuccess(GetAlbumsOfSongResponse object) {
        activity.LoadAlbums(object.albums);
        activity.SetTableHeader("List of albums with song \""+object.song.Name+"\":");
    }
}
