/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.http.exceptions;

/**
 *
 * @author John
 */
public class CannotParseResponseException extends Exception{
    public CannotParseResponseException(String Message){
        super(Message);
    }
}
