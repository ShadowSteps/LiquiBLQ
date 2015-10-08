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
public class TextFieldContainsEmailValidator extends TextFieldValidator{
    private static final String EMAIL_PATTERN = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    @Override
    protected Boolean ValidateTextField(TextField Field) throws ValidationFailedException {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(Field.getText());
        Boolean Check = matcher.matches();
        if (!Check){
            throw new ValidationFailedException("Field must contain a valid Email!");            
        }
        return Check;
    }
    
}

