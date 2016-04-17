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
public class EntityCannotBeEditedException extends Exception{
    public EntityCannotBeEditedException(String Message){
        super(Message);
    }
    public EntityCannotBeEditedException(String Message,Exception ex){
        super(Message,ex);
    }
}
