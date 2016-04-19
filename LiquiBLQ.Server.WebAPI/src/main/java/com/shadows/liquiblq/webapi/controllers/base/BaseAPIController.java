/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.controllers.base;

import com.shadows.liquiblq.data.hibernate.LiquiBlqContext;
import com.shadows.liquiblq.data.interfaces.ILiquiBlqContext;
import com.shadows.liquiblq.webapi.validation.RequestValidator;

/**
 *
 * @author John
 */
public class BaseAPIController{
    protected final ILiquiBlqContext Context;
    protected final RequestValidator Validator;
        
    public BaseAPIController() {
        this.Context = new LiquiBlqContext();
        this.Validator = new RequestValidator(Context);
    }    
}
