/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.tasks;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import java.util.UUID;

/**
 *
 * @author John
 */
public class GetArtistsInAlbumTask extends RunnableTask<JSONResponse> {
    private final String ApiUrl;
    private final UUID SessinKey;
    private final UUID Id;
    private final Integer UserId;

    public GetArtistsInAlbumTask(String ApiUrl, UUID SessinKey, Integer UserId, UUID Id) {
        this.ApiUrl = ApiUrl;
        this.SessinKey = SessinKey;
        this.UserId = UserId;
        this.Id = Id;
    }
    @Override
    protected JSONResponse doRoutine() throws Exception {
        return RequestsManager.doGetArtistsInAlbumRequest(ApiUrl, SessinKey, UserId, Id);
    }
    
}
