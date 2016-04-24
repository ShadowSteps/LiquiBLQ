package com.shadows.liquiblq.client.android.core.UIHandlers;

import com.shadows.liquiblq.client.android.activities.LoginActivity;
import com.shadows.liquiblq.common.communication.json.LoginResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public class LoginUIHandler extends AUITaskHandler<LoginActivity, LoginResponse> {
    public LoginUIHandler(LoginActivity activity) {
        super(activity, "Logging in....", "Successfully logged in!");
    }

    @Override
    protected void OnSuccess(LoginResponse object) {
        activity.Login(object.email,object.sessionKey,object.id);
    }
}
