package com.shadows.liquiblq.client.android.core.UIHandlers;

import android.os.Handler;

import com.shadows.liquiblq.client.android.activities.RegisterActivity;
import com.shadows.liquiblq.client.android.core.managers.ActivityManager;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.managers.DialogManager;
import com.shadows.liquiblq.common.communication.json.ErrorResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;

import java.util.ArrayList;

/**
 * Created by John on 24.4.2016 г..
 */
public class RegisterUIHandler extends AUITaskHandler<RegisterActivity, RegisterResponse> {
    public RegisterUIHandler(RegisterActivity activity) {
        super(activity, "Registering.....", "Successful registration!");
    }

    @Override
    protected void OnSuccess(RegisterResponse object) {
        activity.LoginWithRegistrationInfo(object);
    }
}
