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
public class EntityCannotByCreatedException extends Exception{
    public EntityCannotByCreatedException(String Message){
        super(Message);
    }
    public EntityCannotByCreatedException(String Message,Exception ex){
        super(Message,ex);
    }
}
