/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation;

import com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException;
import javafx.scene.control.TextField;

/**
 *
 * @author John
 */
public class TextFieldMatchOtherFieldValidator extends TextFieldValidator{
    private final TextField SecondField;
    public TextFieldMatchOtherFieldValidator(TextField Field){
        SecondField = Field;
    }
    @Override
    protected Boolean ValidateTextField(TextField Field) throws ValidationFailedException {        
        Boolean Check = Field.getText().compareTo(this.SecondField.getText()) == 0;
        if (!Check){
            throw new ValidationFailedException("Field does not match value in second field!");            
        }
        return Check;
    }
    
}
