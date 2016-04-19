/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.validation;

import com.shadows.liquiblq.data.interfaces.ILiquiBlqContext;
import com.shadows.liquiblq.data.interfaces.dto.Session;
import com.shadows.liquiblq.data.interfaces.dto.User;
import com.shadows.liquiblq.webapi.exceptions.RequestValidationException;
import java.util.Objects;
import java.util.UUID;




/**
 *
 * @author mihail
 */
public class RequestValidator {   
    public final ILiquiBlqContext Context;

    public RequestValidator(ILiquiBlqContext Context) {
        this.Context = Context;
    }
    
    public void ValidateRequest(UUID sessKey,int user_id) throws Exception{
        User user = Context.getUsersSet().GetById(user_id);
        Session Sess = Context.getSessionsSet().GetById(sessKey);
        if(!Objects.equals(user.Id, Sess.UserId)){
            throw new RequestValidationException("Session.User does not match the user_id!");
        }
    }
}
