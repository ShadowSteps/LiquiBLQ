package com.shadows.liquiblq.client.android.core.UIHandlers;

import android.app.Activity;
import android.os.Handler;

import com.shadows.liquiblq.client.android.activities.RegisterActivity;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.managers.DialogManager;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;

/**
 * Created by John on 24.4.2016 г..
 */
public abstract class AUITaskHandler<TActivity extends Activity,TSuccess> extends Handler {
    public static final int startProcessState = 1;
    public static final int successfulRegistrationState = 2;
    public static final int errorOnRegistrationState = 3;
    public static final int exceptionOnRegistrationState = 4;
    protected final TActivity activity;
    private String loadingMessage;
    private String successMessage;

    public AUITaskHandler(TActivity activity,String LoadingMessage,String SuccessMessage) {
        this.activity = activity;
        loadingMessage = LoadingMessage;
        successMessage = SuccessMessage;
    }

    @Override
    public void handleMessage(android.os.Message msg) {
        switch (msg.what){
            case startProcessState:
                DialogManager.ShowLoadingDialog(activity, loadingMessage);
                break;
            case successfulRegistrationState:
                DialogManager.CloseLoadingDialog();
                TSuccess info = (TSuccess) msg.obj;
                AlertManager.ShowMessageAlert(activity, successMessage);
                OnSuccess(info);
                break;
            case exceptionOnRegistrationState:
                DialogManager.CloseLoadingDialog();
                Exception error = (Exception) msg.obj;
                AlertManager.ShowErrorAlert(activity, error.getMessage());
                break;
            case errorOnRegistrationState:
                DialogManager.CloseLoadingDialog();
                Exception errorInfo = (Exception) msg.obj;
                AlertManager.ShowErrorAlert(activity, errorInfo.getMessage());
                break;
        }
    }

    protected abstract void OnSuccess(TSuccess object);
}
