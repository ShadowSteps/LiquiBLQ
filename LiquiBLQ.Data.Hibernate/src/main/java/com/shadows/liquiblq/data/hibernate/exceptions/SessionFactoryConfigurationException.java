/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate.exceptions;

/**
 *
 * @author John
 */
public class SessionFactoryConfigurationException extends Exception{
    public SessionFactoryConfigurationException(String Message){
        super(Message);
    }
    public SessionFactoryConfigurationException(String Message, Exception e){
        super(Message,e);
    }
}
