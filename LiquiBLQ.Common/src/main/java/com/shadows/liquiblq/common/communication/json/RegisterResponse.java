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
public class RegisterResponse extends JSONResponse{
    private final Boolean Status;

    public RegisterResponse(Boolean Status) {
        this.Status = Status;
    }
    public Boolean getStatus() {
        return Status;
    }
    
}
