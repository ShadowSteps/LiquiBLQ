/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

/**
 *
 * @author toshiba
 */
public class LoginResponse extends JSONResponse {    

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }
    public Boolean Status;   
    public LoginResponse(Boolean Result){
        this.Status = Result;
    }
    public LoginResponse(){
        
    }
}
