/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

/**
 *
 * @author John
 */
public class ErrorResponse extends JSONResponse{
    public final String ExceptionType;
    public final String ExceptionMessage;
    public ErrorResponse(Exception Ex){
        this.ExceptionMessage = Ex.getMessage();
        this.ExceptionType = Ex.getClass().getName();
    }    
}
