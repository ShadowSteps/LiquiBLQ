/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author John
 */
public class User {
    public int Id;
    public String Email;
    public String Password;
    public String Salt;
    public String Name;
    public Date DateRegistered;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.Id;
        hash = 37 * hash + Objects.hashCode(this.Email);
        hash = 37 * hash + Objects.hashCode(this.Password);
        hash = 37 * hash + Objects.hashCode(this.Salt);
        hash = 37 * hash + Objects.hashCode(this.Name);
        hash = 37 * hash + Objects.hashCode(this.DateRegistered);
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
        final User other = (User) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        if (!Objects.equals(this.Salt, other.Salt)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.DateRegistered, other.DateRegistered)) {
            return false;
        }
        return true;
    }
    
}
