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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public Boolean status;
    public RegisterResponse(Boolean status) {
        this.status = status;
    }
    public RegisterResponse(){
        
    }
}
