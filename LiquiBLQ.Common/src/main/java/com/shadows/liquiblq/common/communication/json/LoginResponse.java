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
    
    public LoginResponse(Boolean Status, UUID SessionKey, String Email, Integer Id) {
        this.status = Status;
        this.sessionKey = SessionKey;
        this.email = Email;
        this.id = Id;
    }
}
