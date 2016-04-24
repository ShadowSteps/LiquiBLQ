/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.tasks;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.common.communication.json.JSONResponse;

/**
 *
 * @author John
 */
public class UserRegisterTask extends RunnableTask<JSONResponse> {
    private final String ApiUrl;
    private final String Username;
    private final String Password;
    private final String Name;

    public UserRegisterTask(String ApiUrl, String Username, String Password, String Name) {
        this.ApiUrl = ApiUrl;
        this.Username = Username;
        this.Password = Password;
        this.Name = Name;
    }
    
    @Override
    protected JSONResponse doRoutine() throws Exception {
        return RequestsManager.doRegisterRequest(ApiUrl, Username, Password, Name);
    }
    
}
