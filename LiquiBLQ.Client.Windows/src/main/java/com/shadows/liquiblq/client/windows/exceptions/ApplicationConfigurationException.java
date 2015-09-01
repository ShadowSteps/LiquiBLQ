/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.exceptions;

/**
 *
 * @author John
 */
public class ApplicationConfigurationException extends Exception{
    public ApplicationConfigurationException(String Message){
        super(Message);
    }
    public ApplicationConfigurationException(String Message,Exception exp){
        super(Message,exp);
    }
}
