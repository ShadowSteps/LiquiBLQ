/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.exceptions;

/**
 *
 * @author John
 */
public class HttpRequestErrorException extends Exception{
    public HttpRequestErrorException(String Message){
        super(Message);
    }
}
