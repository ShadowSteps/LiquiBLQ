package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetAllArtistsUIHandler extends AUITaskHandler<MainFormActivity, GetAllArtistsResponse> {
    public GetAllArtistsUIHandler(MainFormActivity activity) {
        super(activity, "Loading artists...", "Successfully loaded artists!");
    }

    @Override
    protected void OnSuccess(GetAllArtistsResponse object) {
        activity.LoadArtists(object.artists);
        activity.SetTableHeader("List of artists:");
    }
}
