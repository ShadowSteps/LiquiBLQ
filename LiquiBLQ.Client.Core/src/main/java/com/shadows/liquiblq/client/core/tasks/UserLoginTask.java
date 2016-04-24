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
public class UserLoginTask extends RunnableTask<JSONResponse> {
    private final String ApiUrl;
    private final String Username;
    private final String Password;

    public UserLoginTask(String ApiUrl, String Username, String Password) {
        this.ApiUrl = ApiUrl;
        this.Username = Username;
        this.Password = Password;
    }
    
    @Override
    protected JSONResponse doRoutine() throws Exception {
        return RequestsManager.doLoginRequest(ApiUrl, Username, Password);
    }
    
}
