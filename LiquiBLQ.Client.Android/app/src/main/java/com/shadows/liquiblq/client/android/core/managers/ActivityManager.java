package com.shadows.liquiblq.client.android.core.managers;

import android.app.Activity;
import android.content.Intent;

import com.shadows.liquiblq.client.android.activities.LoginActivity;
import com.shadows.liquiblq.client.android.activities.RegisterActivity;

/**
 * Created by John on 17.3.2016 г..
 */
public class ActivityManager {
    public static void OpenLoginActivity(Activity parent){
        parent.startActivityForResult(new Intent(parent, LoginActivity.class), 1);
    }
    public static void OpenRegisterActivity(Activity parent){
        parent.startActivityForResult(new Intent(parent, RegisterActivity.class), 1);
    }
}
