/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.controllers;

import com.shadows.liquiblq.client.core.RequestsManager;
import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import com.shadows.liquiblq.client.windows.config.AppConfig;
import com.shadows.liquiblq.client.windows.config.ConfigurationManager;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldContainsEmailValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldMatchOtherFieldValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldMaxLengthValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldMinLengthValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldNotEmptyValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldValidator;
import com.shadows.liquiblq.client.windows.core.validation.controls.AlertsManager;
import com.shadows.liquiblq.client.windows.core.validation.listeners.TextFieldChangeListener;
import com.shadows.liquiblq.client.windows.core.validation.utils.ValidationManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author John
 */
public class LoginController implements Initializable{

    @FXML
    private TabPane loginTabsPanel;        
    @FXML
    private AnchorPane MainPanel;    
    @FXML
    private TextField RegisterEmail;
    @FXML
    private TextField LoginEmail;
    @FXML
    private TextField RegisterName;
    @FXML
    private PasswordField RegisterPassword;
    @FXML
    private PasswordField RegisterRepeatPassword;
    @FXML
    private PasswordField LoginPassword;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    
    private TextFieldChangeListener LoginEmailValidatorListener,
            LoginPasswordValidatorListener,
            RegisterPasswordValidatiorListener,
            RegisterEmailValidatiorListener,
            RegisterPasswordRepeatValidatiorListener,
            RegisterNameValidatiorListener;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {        
        LoginEmailValidatorListener = ValidationManager.BindTextFieldChangeValidator(LoginEmail,new TextFieldValidator[]{
            new TextFieldNotEmptyValidator(),
            new TextFieldContainsEmailValidator()
        });
        LoginPasswordValidatorListener = ValidationManager.BindTextFieldChangeValidator(LoginPassword, new TextFieldValidator[]{
            new TextFieldNotEmptyValidator()
        });
        RegisterPasswordValidatiorListener = ValidationManager.BindTextFieldChangeValidator(RegisterPassword, new TextFieldValidator[]{
            new TextFieldNotEmptyValidator(),
            new TextFieldMinLengthValidator(5),
            new TextFieldMaxLengthValidator(64)
        });
        RegisterPasswordRepeatValidatiorListener = ValidationManager.BindTextFieldChangeValidator(RegisterRepeatPassword, new TextFieldValidator[]{
            new TextFieldNotEmptyValidator(),
            new TextFieldMinLengthValidator(5),
            new TextFieldMaxLengthValidator(64),
            new TextFieldMatchOtherFieldValidator(RegisterPassword)
        });
        RegisterEmailValidatiorListener = ValidationManager.BindTextFieldChangeValidator(RegisterEmail,new TextFieldValidator[]{
            new TextFieldNotEmptyValidator(),
            new TextFieldContainsEmailValidator()
        });
        RegisterNameValidatiorListener = ValidationManager.BindTextFieldChangeValidator(RegisterName, new TextFieldValidator[]{
            new TextFieldNotEmptyValidator()
        });
    }
    
    protected void resizeStage(){
        Stage stage = (Stage)MainPanel.getScene().getWindow();
        stage.sizeToScene();
    }
    
    @FXML
    private void onRegisterButtonClick(){
        Boolean isValid = 
                RegisterEmailValidatiorListener.ValidateFields()
                && RegisterPasswordValidatiorListener.ValidateFields()
                && RegisterPasswordRepeatValidatiorListener.ValidateFields()
                && RegisterNameValidatiorListener.ValidateFields()
                ;
        Alert alert = new Alert(Alert.AlertType.ERROR);           
        if (!isValid){        
            AlertsManager.ShowErrorAlert("Invalid data provided","Please check your input fields for errors and try to submit the form again!");
        } else {
            try {
                AppConfig conf = ConfigurationManager.GetApplicationConfiguration();
                String ApiUrl = conf.getApiUrl();
                try {
                    RegisterResponse Resp = (RegisterResponse)RequestsManager.doRegisterRequest(ApiUrl, RegisterEmail.getText(), RegisterPassword.getText(),RegisterName.getText());
                    AlertsManager.ShowInfoAlert("Register successfull!", "Welcome, you are registered as:");
                    Stage stage = (Stage)registerButton.getScene().getWindow();                     
                    stage.close();
                } catch (HttpRequestErrorException ex) {
                    AlertsManager.ShowErrorAlert("Server not responding","Our attempt to make a request to the server has failed! Please try again later!");
                } catch (CannotParseResponseException ex) {
                    AlertsManager.ShowErrorAlert("Internal server error","The response of the server was invalid! Please try again later!");
                }
            } catch (ApplicationConfigurationException ex) {
                AlertsManager.ShowErrorAlert("Invalid client configuration","Your client was not configured porperly!Please reinstall");
            }
        }
    }
    
    @FXML
    private void onLoginButtonClick(){
        Boolean isValid = 
            LoginEmailValidatorListener.ValidateFields()
            && LoginPasswordValidatorListener.ValidateFields();
        if (!isValid){
            AlertsManager.ShowErrorAlert("Invalid username or password", "Please check your input fields and try to submit the form again!");
        } else {
            try {
                AppConfig conf = ConfigurationManager.GetApplicationConfiguration();
                String ApiUrl = conf.getApiUrl();
                try {
                    LoginResponse Response = (LoginResponse)RequestsManager.doLoginRequest(ApiUrl, LoginEmail.getText(), LoginPassword.getText());  
                    AlertsManager.ShowInfoAlert("Login successfull!", "Welcome, you are logged in as:");
                    Stage stage = (Stage)loginButton.getScene().getWindow();
                    stage.close();
                } catch (HttpRequestErrorException ex) {
                    AlertsManager.ShowErrorAlert("Server not responding","Our attempt to make a request to the server has failed! Please try again later!");
                } catch (CannotParseResponseException ex) {
                    AlertsManager.ShowErrorAlert("Internal server error","The response of the server was invalid! Please try again later!");
                }
            } catch (ApplicationConfigurationException ex) {
                AlertsManager.ShowErrorAlert("Invalid client configuration","Your client was not configured porperly!Please reinstall");
            }
        }
        
    }
}
