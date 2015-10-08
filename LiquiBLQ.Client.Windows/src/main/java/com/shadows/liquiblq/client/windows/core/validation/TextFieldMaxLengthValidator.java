/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation;

import com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

/**
 *
 * @author John
 */
public class TextFieldMaxLengthValidator extends TextFieldValidator{
    private final Integer MaxLength;
    public TextFieldMaxLengthValidator(Integer Length){
        MaxLength = Length;
    }
    @Override
    protected Boolean ValidateTextField(TextField Field) throws ValidationFailedException {        
        Boolean Check = Field.getText().length() <= this.MaxLength;
        if (!Check){
            throw new ValidationFailedException("Field must contain maximum of "+MaxLength+" characters!");            
        }
        return Check;
    }
    
}
