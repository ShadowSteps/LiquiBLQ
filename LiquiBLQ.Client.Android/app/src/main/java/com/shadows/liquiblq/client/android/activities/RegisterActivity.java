package com.shadows.liquiblq.client.android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

import com.shadows.liquiblq.client.android.R;
import com.shadows.liquiblq.client.android.core.UIHandlers.RegisterUIHandler;
import com.shadows.liquiblq.client.android.core.managers.AlertManager;
import com.shadows.liquiblq.client.android.core.tasks.TasksManager;
import com.shadows.liquiblq.client.android.exceptions.ValidationException;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;

/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends AppCompatActivity {
   // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private EditText mPasswordRepeatView;
    private EditText mNameView;
    private View mProgressView;
    private View mLoginFormView;
    private RegisterUIHandler handler;
    private TasksManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordRepeatView = (EditText) findViewById(R.id.password_repeat);
        mNameView = (EditText) findViewById(R.id.name);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        this.handler = new RegisterUIHandler(this);
        manager = new TasksManager(getResources().getString(R.string.api_url));
    }

    public void doRegister(View view){
        String Email = mEmailView.getText().toString();
        String Password = mPasswordView.getText().toString();
        String RepeatPassword = mPasswordRepeatView.getText().toString();
        String Name = mNameView.getText().toString();
        try{
            validateEmail(Email);
            validatePassword(Password, RepeatPassword);
            validateName(Name);
            manager.StartRegisterTask(handler, Email, Password, Name);
        }
        catch (ValidationException exp){
            AlertManager.ShowErrorAlert(this,exp.getMessage());
        }
        catch (Exception exp){
            AlertManager.ShowErrorAlert(this,"System exception occured!");
        }

    }

    private void validateEmail(String email) throws ValidationException {
        if (email.length() < 5)
            throw new ValidationException("Email is too short!");
        if (!email.matches("[a-zA-Z0-9-_]+@[a-zA-Z0-9]+.[a-zA-Z]+"))
            throw new ValidationException("Email is not valid!");
    }

    private void validatePassword(String password,String repeat) throws ValidationException {
        if (password.length() < 5)
            throw new ValidationException("Password must be atleast 5 chars!");
        if (!Objects.equals(password, repeat))
            throw new ValidationException("Two password does not match!");
    }

    private void validateName(String name) throws ValidationException {
        if (name.length() < 3)
            throw new ValidationException("Name must be atleast 3 chars!");
    }

    public void LoginWithRegistrationInfo(RegisterResponse regInfo) {
        Intent intent = new Intent();
        intent.putExtra("REG_EMAIL",regInfo.email);
        setResult(RESULT_OK, intent);
        finish();
    }
}

