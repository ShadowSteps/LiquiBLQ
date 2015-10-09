/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.validation;

import com.shadows.liquiblq.data.entitys.Sessions;
import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.exceptions.EntityCannotBeFoundException;
import com.shadows.liquiblq.data.repositories.SessionsRepository;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import java.util.Objects;
import java.util.UUID;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import sun.invoke.empty.Empty;




/**
 *
 * @author mihail
 */
public class RequestValidator {
    
    public static void validateRequest(UUID sessKey,int user_id) throws RequestValidationException, EntityCannotBeFoundException{
        Users user = UsersRepository.GetUserById(user_id);
        Sessions Sess = SessionsRepository.GetSessionById(sessKey);
        if(!Objects.equals(user.getId(), Sess.getUserId())){
            throw new RequestValidationException("Seession_User does not match the user_Id!");
        }
    }
}
