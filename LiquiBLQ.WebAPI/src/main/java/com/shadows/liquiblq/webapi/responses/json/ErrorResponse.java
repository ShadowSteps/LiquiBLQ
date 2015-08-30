/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.webapi.responses.json;

/**
 *
 * @author John
 */
public class ErrorResponse extends JSONResponse{
    private final String ExceptionType;
    private final String ExceptionMessage;
    public ErrorResponse(Exception Ex){
        this.ExceptionMessage = Ex.getMessage();
        this.ExceptionType = Ex.getClass().getName();
    }
    
    public String getExceptionType() {
        return ExceptionType;
    }

    public String getExceptionMessage() {
        return ExceptionMessage;
    }
}
