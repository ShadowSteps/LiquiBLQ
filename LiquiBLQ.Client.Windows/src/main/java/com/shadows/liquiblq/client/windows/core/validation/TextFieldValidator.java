/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation;

import com.shadows.liquiblq.client.windows.core.validation.exceptions.FieldTypeNotSupportedByValidatorException;
import com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

/**
 * @class TextFieldValidator
 * @author John
 * @abstract
 */

public abstract class TextFieldValidator extends FieldValidator {
    /**
     * 
     * @param Field
     * @return Boolean
     * @throws FieldTypeNotSupportedByValidatorException 
     * @throws com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException 
     */
    @Override
    public Boolean ValidateField(Control Field) throws FieldTypeNotSupportedByValidatorException,ValidationFailedException {
        if (!(Field instanceof TextField)){
            throw new FieldTypeNotSupportedByValidatorException(this.getClass().getName()+" does not support type of field: "+Field.getClass().getName());
        }
        return ValidateTextField((TextField)Field);
    }   
    /**
     * 
     * @param Field
     * @return 
     * @throws com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException 
     */
    protected  abstract Boolean ValidateTextField(TextField Field) throws ValidationFailedException;
}
