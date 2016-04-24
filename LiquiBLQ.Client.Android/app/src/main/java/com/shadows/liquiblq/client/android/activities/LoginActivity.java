package com.shadows.liquiblq.client.android.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.shadows.liquiblq.client.android.R;
import com.shadows.liquiblq.client.android.config.LoginSession;
import com.shadows.liquiblq.client.android.core.UIHandlers.LoginUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.RegisterUIHandler;
import com.shadows.liquiblq.client.android.core.managers.ActivityManager;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;
import com.shadows.liquiblq.client.android.exceptions.ValidationException;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private LoginUIHandler handler;
    private TasksManager manager;

    @Override
    public void onBackPressed(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        handler = new LoginUIHandler(this);
        manager = new TasksManager(getResources().getString(R.string.api_url));
    }

    public void openRegisterForm(View view){
        ActivityManager.OpenRegisterActivity(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String Email = data.getStringExtra("REG_EMAIL");
                this.LoadInfo(Email,"");
            }
        }
    }

    public void LoadInfo(String Username,String Password){
        this.mEmailView.setText(Username);
        this.mPasswordView.setText(Password);
        this.mPasswordView.requestFocus();
    }

    public void Login(String Email, UUID SessinKey, Integer UserId){
        LoginSession.UserId = UserId;
        LoginSession.sessionKey = SessinKey;
        LoginSession.Email = Email;
        if (LoginSession.IsLoggedIn()){
            Intent intent = new Intent();
            intent.putExtra("LOGIN_STATUS", true);
            setResult(RESULT_OK, intent);
            finish();
        }
        else
            AlertManager.ShowErrorAlert(this,"Could save login system variables!");
    }

    public void doLogin(View view){
        String Email = mEmailView.getText().toString();
        String Password = mPasswordView.getText().toString();
        try{
            validateEmail(Email);
            validatePassword(Password);
            manager.StartLoginTask(handler, Email, Password);
        }
        catch (ValidationException exp){
            AlertManager.ShowErrorAlert(this,exp.getMessage());
        }
        catch (Exception exp){
            AlertManager.ShowErrorAlert(this,"System exception occurred!");
        }

    }

    private void validatePassword(String password) throws ValidationException {
        if (password.length() < 5)
            throw new ValidationException("Password must be atleast 5 chars!");
    }

    private void validateEmail(String email) throws ValidationException {
        if (email.length() < 5)
            throw new ValidationException("Email is too short!");
        if (!email.matches("[a-zA-Z0-9-_]+@[a-zA-Z0-9]+.[a-zA-Z]+"))
            throw new ValidationException("Email is not valid!");
    }
}

