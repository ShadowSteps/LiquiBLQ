/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import java.util.Objects;

/**
 *
 * @author John
 */
public class ErrorResponse extends JSONResponse{
    public String ExceptionType;
    public String ExceptionMessage;
    public ErrorResponse(Exception Ex){
        this.ExceptionMessage = Ex.getMessage();
        this.ExceptionType = Ex.getClass().getName();
    }    

    public ErrorResponse() {       
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.ExceptionType);
        hash = 97 * hash + Objects.hashCode(this.ExceptionMessage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ErrorResponse other = (ErrorResponse) obj;
        if (!Objects.equals(this.ExceptionType, other.ExceptionType)) {
            return false;
        }
        if (!Objects.equals(this.ExceptionMessage, other.ExceptionMessage)) {
            return false;
        }
        return true;
    }
    
    
}
