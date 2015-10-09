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
public class UserNotLoggedInException extends Exception{
    public UserNotLoggedInException(){
        super("User is not logged in!");
    }
}
