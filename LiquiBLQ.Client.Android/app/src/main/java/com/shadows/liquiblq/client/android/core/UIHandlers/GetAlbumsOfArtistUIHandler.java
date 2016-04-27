package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfArtistResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistsInAlbumResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetAlbumsOfArtistUIHandler extends AUITaskHandler<MainFormActivity, GetAlbumsOfArtistResponse> {
    public GetAlbumsOfArtistUIHandler(MainFormActivity activity) {
        super(activity, "Loading Albums", "Successfully loaded albums!");
    }

    @Override
    protected void OnSuccess(GetAlbumsOfArtistResponse object) {
        activity.LoadAlbums(object.albums);
        activity.SetTableHeader("List of albums by artist \""+object.artist.Name+"\":");
    }
}
