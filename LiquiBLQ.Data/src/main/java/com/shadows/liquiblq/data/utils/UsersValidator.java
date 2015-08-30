/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.utils;

import com.shadows.liquiblq.common.utils.StringValidator;
import com.shadows.liquiblq.data.exceptions.InvalidEntiryProvidedBeforeInsertException;
import com.shadows.liquiblq.data.entitys.Users;

/**
 *
 * @author John
 */
public class UsersValidator {
    public static final int EmailMaxLength = 55;
    public static final int EmailMinLength = 5;
    public static final int NameMaxLength = 55;
    public static final int PasswordMinLength = 8;
    public static final int PasswordMaxLength = 36;
    public static final int HashedPasswordLength = 64;
    public static final int SaltLength = 5;
    
    public static void ValidateUserBeforeInsert(Users User) throws InvalidEntiryProvidedBeforeInsertException{
        if (!StringValidator.Between(User.getEmail(), EmailMinLength, EmailMaxLength)){
            throw new InvalidEntiryProvidedBeforeInsertException("Email must be between "+EmailMinLength+" and "+EmailMaxLength+" characters long!");
        }
        if (User.getPassword().length() != HashedPasswordLength){
            throw new InvalidEntiryProvidedBeforeInsertException("Hashed password must be "+HashedPasswordLength+" characters long!");
        }
        if (User.getSalt().length() != SaltLength){
            throw new InvalidEntiryProvidedBeforeInsertException("Salt must be "+SaltLength+" characters long!");
        }
        if (!StringValidator.Between(User.getName(), 0, NameMaxLength)){
            throw new InvalidEntiryProvidedBeforeInsertException("Name must be between "+0+" and "+NameMaxLength+" characters long!");
        }
    }
}
