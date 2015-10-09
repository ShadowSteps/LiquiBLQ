/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.exceptions;

/**
 *
 * @author mihail
 */
public class RequestValidationException extends Exception{
    public RequestValidationException(String message){
        super(message);
    }
}
