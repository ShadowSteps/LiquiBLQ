/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.exceptions;

/**
 *
 * @author John
 */
public class InvalidEntiryProvidedBeforeInsertException extends Exception {
    public InvalidEntiryProvidedBeforeInsertException(String Message){
        super(Message);
    }
}
