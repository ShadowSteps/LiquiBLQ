/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import java.util.UUID;

/**
 *
 * @author toshiba
 */
public class LoginResponse extends JSONResponse {    
    public Boolean status;   
    public UUID sessionKey;
    public String email;
    public Integer id;
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean Status) {
        this.status = Status;
    }
    
    public UUID getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(UUID SessionKey) {
        this.sessionKey = SessionKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public Integer getId() {
        return id;
    }

    public LoginResponse(Boolean Status, UUID SessionKey, String Email, Integer Id) {
        this.status = Status;
        this.sessionKey = SessionKey;
        this.email = Email;
        this.id = Id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }
   
    public LoginResponse(){
        
    }
}
