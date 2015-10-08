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
public class TextFieldMinLengthValidator extends TextFieldValidator{
    private final Integer MinLength;
    public TextFieldMinLengthValidator(Integer Length){
        MinLength = Length;
    }
    @Override
    protected Boolean ValidateTextField(TextField Field) throws ValidationFailedException {        
        Boolean Check = Field.getText().length() >= this.MinLength;
        if (!Check){
            throw new ValidationFailedException("Field must contain minimum of "+MinLength+" characters!");            
        }
        return Check;
    }
    
}
