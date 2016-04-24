/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import java.util.Objects;
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

    public LoginResponse() {
    }
    
    
    public LoginResponse(Boolean Status, UUID SessionKey, String Email, Integer Id) {
        this.status = Status;
        this.sessionKey = SessionKey;
        this.email = Email;
        this.id = Id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.status);
        hash = 29 * hash + Objects.hashCode(this.sessionKey);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final LoginResponse other = (LoginResponse) obj;
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.sessionKey, other.sessionKey)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
