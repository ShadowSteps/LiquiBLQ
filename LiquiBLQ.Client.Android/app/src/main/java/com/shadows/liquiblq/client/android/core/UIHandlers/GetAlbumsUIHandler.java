package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.MainFormActivity;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class GetAlbumsUIHandler extends AUITaskHandler<MainFormActivity, GetAllAlbumsResponse> {
    public GetAlbumsUIHandler(MainFormActivity activity) {
        super(activity, "Loading Albums", "Successfully loaded albums!");
    }

    @Override
    protected void OnSuccess(GetAllAlbumsResponse object) {
        activity.LoadAlbums(object.albums);
        activity.SetTableHeader("List of ablums:");
    }
}
