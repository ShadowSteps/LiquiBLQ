/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation;

import com.shadows.liquiblq.client.windows.core.validation.exceptions.FieldTypeNotSupportedByValidatorException;
import com.shadows.liquiblq.client.windows.core.validation.exceptions.ValidationFailedException;
import javafx.scene.control.Control;

/**
 *
 * @author John
 */
public abstract class FieldValidator {
    public abstract Boolean ValidateField(Control Field) throws FieldTypeNotSupportedByValidatorException,ValidationFailedException;
}
