/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.validation;

import com.shadows.liquiblq.data.entitys.Users;
import com.shadows.liquiblq.data.repositories.UsersRepository;
import java.util.UUID;
import org.springframework.boot.autoconfigure.security.SecurityProperties;



/**
 *
 * @author mihail
 */
public class RequestValidator {
    
    public void validateRequest(UUID sessKey,int user_id){
        Users = UsersRepository.GetUserById(user_id);
  
    }
    
    
}
