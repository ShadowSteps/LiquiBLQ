/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.validation.exceptions;

/**
 *
 * @author John
 */
public class ValidationFailedException extends Exception{
    public ValidationFailedException(String Message){
        super(Message);
    }
}
