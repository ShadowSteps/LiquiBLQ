package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetArtistsInAlbumResponse;
import com.shadows.liquiblq.common.communication.json.GetSongsInAlbumResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetSongsInAlbumUIHandler extends AUITaskHandler<MainFormActivity, GetSongsInAlbumResponse> {
    public GetSongsInAlbumUIHandler(MainFormActivity activity) {
        super(activity, "Loading songs...", "Successfully loaded songs!");
    }

    @Override
    protected void OnSuccess(GetSongsInAlbumResponse object) {
        activity.LoadSongs(object.songs);
        activity.SetTableHeader("List of songs in album \""+object.album.Name+"\":");
    }
}
