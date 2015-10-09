/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.utils;

import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.exceptions.InvalidEntiryProvidedBeforeInsertException;

/**
 *
 * @author John
 */
public class SessionsValidator {
    public static void ValidateUserInsert(Sessions Session) throws InvalidEntiryProvidedBeforeInsertException{
        if (!(Session.getUserId() != 0 && Session.getUserId() > 0)){
            throw new InvalidEntiryProvidedBeforeInsertException("Session must have assigned userId before inserting to database!");
        }
    }
}
