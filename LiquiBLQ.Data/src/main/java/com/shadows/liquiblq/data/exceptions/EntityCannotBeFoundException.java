/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.exceptions;

/**
 *
 * @author toshiba
 */
public class EntityCannotBeFoundException  extends Exception{
    public EntityCannotBeFoundException(String Message){
        super(Message);
    }
}
