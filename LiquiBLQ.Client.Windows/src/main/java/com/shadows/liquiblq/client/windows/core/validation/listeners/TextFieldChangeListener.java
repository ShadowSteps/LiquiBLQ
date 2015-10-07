/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.listeners;

import com.shadows.liquiblq.client.windows.core.validation.TextFieldValidator;
import com.shadows.liquiblq.client.windows.core.validation.exceptions.FieldTypeNotSupportedByValidatorException;
import com.shadows.liquiblq.client.windows.core.validation.utils.ValidationManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author John
 */
public class TextFieldChangeListener implements ChangeListener {
    TextFieldValidator[] Validators;
    TextField Field;    
    public TextFieldChangeListener(TextFieldValidator[] TextValidator,TextField TestField){
        this.Validators = TextValidator;
        this.Field = TestField;
    }
    public Boolean ValidateFields(){
        Boolean Check = true;
        for (TextFieldValidator Validator : Validators) {
            try {
                Check = ValidationManager.ValidateField(Validator, Field);
                if (!Check){
                    break;
                }
            } catch (FieldTypeNotSupportedByValidatorException ex) {
                Check = false;
                break;               
            }
        }
        return Check;
    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        ValidateFields();
    }
    
}
