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
public class TextFieldNotEmptyValidator extends TextFieldValidator{

    @Override
    protected Boolean ValidateTextField(TextField Field) throws ValidationFailedException {
        Boolean Check = Field.getText() != null && !Field.getText().isEmpty() && Field.getText().length() > 0;
        if (!Check){
            throw new ValidationFailedException("Field must not be empty!");            
        }
        return Check;
    }
    
}
