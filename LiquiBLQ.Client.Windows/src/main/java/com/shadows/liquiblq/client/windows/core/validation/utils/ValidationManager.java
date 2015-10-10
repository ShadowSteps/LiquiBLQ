/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.utils;

import com.shadows.liquiblq.client.windows.core.validation.FieldValidator;
import com.shadows.liquiblq.client.windows.core.validation.TextFieldValidator;
import com.shadows.liquiblq.client.windows.core.validation.controls.FailedValidationControlMarker;
import com.shadows.liquiblq.client.windows.core.validation.controls.MarkerBaseControl;
import com.shadows.liquiblq.client.windows.core.validation.controls.SuccessfulValidationControlMarker;
import com.shadows.liquiblq.client.windows.core.validation.controls.ValidationResultMarker;
import com.shadows.liquiblq.client.windows.core.validation.exceptions.FieldTypeNotSupportedByValidatorException;
import com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException;
import com.shadows.liquiblq.client.windows.core.validation.listeners.TextFieldChangeListener;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author John
 */
public class ValidationManager {
    protected static MarkerBaseControl MarkerControl;
    public static Boolean ValidateField(FieldValidator Validator,Control Field) throws FieldTypeNotSupportedByValidatorException {
        DestroyMarker();
        ValidationResultMarker Marker = null;
        String Message = "";
        Boolean Result= false;
        try {
            Result = Validator.ValidateField(Field);            
            if (Result){
                Marker = new SuccessfulValidationControlMarker();
                Message = "Input text is valid!";
            } else {
                Marker = new FailedValidationControlMarker();
                Message = "Undefined error!";
            }         
        } catch (ValidationFailedException ex) {
            Marker = new FailedValidationControlMarker();
            Message = ex.getMessage();
        }
        finally{
            MarkerControl = Marker.ApplyMarker(Field,Message);
        }
        return Result;
    }
    public static TextFieldChangeListener BindTextFieldChangeValidator(TextField Field,TextFieldValidator[] TextValidator){
        TextFieldChangeListener Listener = new TextFieldChangeListener(TextValidator, Field);
        Field.textProperty().addListener(Listener); 
        return Listener;
    }
    protected static void DestroyMarker(){
        if (MarkerControl instanceof MarkerBaseControl&&MarkerControl != null){
            ((AnchorPane)MarkerControl.getBackgroundCircle().getParent()).getChildren().remove(MarkerControl.getBackgroundCircle());
            ((AnchorPane)MarkerControl.getSign().getParent()).getChildren().remove(MarkerControl.getSign());
        }
    }
}
