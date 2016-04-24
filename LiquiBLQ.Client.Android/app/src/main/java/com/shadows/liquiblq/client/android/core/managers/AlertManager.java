package com.shadows.liquiblq.client.android.core.managers;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by John on 19.3.2016 г..
 */
public class AlertManager {
    public static void ShowErrorAlert(Activity parent,String error){
        Toast.makeText(parent.getBaseContext(),error,Toast.LENGTH_LONG)
            .show();
    }
    public static void ShowMessageAlert(Activity parent,String message){
        Toast.makeText(parent.getBaseContext(),message,Toast.LENGTH_SHORT)
                .show();
    }
}
