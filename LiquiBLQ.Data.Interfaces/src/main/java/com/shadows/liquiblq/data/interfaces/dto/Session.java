/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.dto;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author John
 */
public class Session {
    public UUID Id;
    public int UserId;
    public boolean IsActive;
    public Date DateCreated;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.Id);
        hash = 83 * hash + this.UserId;
        hash = 83 * hash + (this.IsActive ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.DateCreated);
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
        final Session other = (Session) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (this.UserId != other.UserId) {
            return false;
        }
        if (this.IsActive != other.IsActive) {
            return false;
        }
        if (!Objects.equals(this.DateCreated, other.DateCreated)) {
            return false;
        }
        return true;
    }
    
}
