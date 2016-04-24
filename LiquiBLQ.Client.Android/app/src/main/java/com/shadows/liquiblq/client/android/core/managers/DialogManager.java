package com.shadows.liquiblq.client.android.core.managers;

import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;

import com.shadows.liquiblq.client.android.R;


/**
 * Created by John on 17.3.2016 г..
 */
public class DialogManager {
    private static Dialog LoadingDialog = null;
    public static void ShowSelectProviderDialog(Activity Parent){
    }
    public static void ShowLoadingDialog(Activity Parent){
        ShowLoadingDialog(Parent, "Loading, please wait.....");
    }
    public static void ShowLoadingDialog(Activity Parent, String Message){
        if(LoadingDialog != null){
            CloseLoadingDialog();
        }
        LoadingDialog = new Dialog(Parent);
        LoadingDialog.setContentView(R.layout.loading_dialog);
        LoadingDialog.setCancelable(false);
        TextView text = (TextView) LoadingDialog.findViewById(R.id.LoadingText);
        text.setText(Message);
        LoadingDialog.show();
    }
    public static void CloseLoadingDialog(){
        if (LoadingDialog == null)
            return;
        LoadingDialog.cancel();
        LoadingDialog = null;
    }
}
