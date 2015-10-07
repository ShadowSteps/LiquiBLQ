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
import com.shadows.liquiblq.client.windows.core.validation.TextFieldNotEmptyValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldValidator;
import com.shadows.liquiblq.client.windows.core.validation.listeners.TextFieldChangeListener;
import com.shadows.liquiblq.client.windows.core.validation.utils.ValidationManager;
import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        LoginPasswordValidatorListener;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {        
        LoginEmailValidatorListener = ValidationManager.BindTextFieldChangeValidator(LoginEmail,new TextFieldValidator[]{
            new TextFieldNotEmptyValidator(),
            new TextFieldContainsEmailValidator()
        });
        LoginPasswordValidatorListener = ValidationManager.BindTextFieldChangeValidator(LoginPassword, new TextFieldValidator[]{
            new TextFieldNotEmptyValidator()
        });
    }
    
    protected void resizeStage(){
        Stage stage = (Stage)MainPanel.getScene().getWindow();
        stage.sizeToScene();
    }
    
    @FXML
    private void onRegisterButtonClick(){
        
    }
    
    @FXML
    private void onLoginButtonClick(){
        Boolean isValid = 
            LoginEmailValidatorListener.ValidateFields()
            && LoginPasswordValidatorListener.ValidateFields();
        Alert alert = new Alert(Alert.AlertType.ERROR);           
        if (!isValid){        
            alert.setTitle("Invalid username or password");
            alert.setContentText("Please check your input fields and try to submit the form again!");
            alert.show();
        } else {
            try {
                AppConfig conf = ConfigurationManager.GetApplicationConfiguration();
                String ApiUrl = conf.getApiUrl();
                try {
                    RequestsManager.doLoginRequest(ApiUrl, LoginEmail.getText(), LoginPassword.getText());
                } catch (HttpRequestErrorException ex) {
                    alert.setTitle("Server not responding");
                    alert.setContentText("Our attempt to make a request to the server has failed! Please try again later!");
                    alert.show();
                } catch (CannotParseResponseException ex) {
                    alert.setTitle("Internal server error");
                    alert.setContentText("The response of the server was invalid! Please try again later!");
                    alert.show();
                }
            } catch (ApplicationConfigurationException ex) {
                alert.setTitle("Invalid client configuration");
                alert.setContentText("Your client was not configured porperly!Please reinstall");
                alert.show();
            }
        }
        
    }
}
