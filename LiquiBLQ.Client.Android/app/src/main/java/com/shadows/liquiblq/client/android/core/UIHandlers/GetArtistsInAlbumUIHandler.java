package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistsInAlbumResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetArtistsInAlbumUIHandler extends AUITaskHandler<MainFormActivity, GetArtistsInAlbumResponse> {
    public GetArtistsInAlbumUIHandler(MainFormActivity activity) {
        super(activity, "Loading artists...", "Successfully loaded artists!");
    }

    @Override
    protected void OnSuccess(GetArtistsInAlbumResponse object) {
        activity.LoadArtists(object.artists);
        activity.SetTableHeader("List of artists in album \""+object.album.Name+"\":");
    }
}
