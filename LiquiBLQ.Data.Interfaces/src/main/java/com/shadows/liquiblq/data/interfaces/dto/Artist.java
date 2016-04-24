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
public class Artist {
    public UUID Id;
    public String Name;
    public String Nickname;
    public Date DateOfBirth;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.Id);
        hash = 37 * hash + Objects.hashCode(this.Name);
        hash = 37 * hash + Objects.hashCode(this.Nickname);
        hash = 37 * hash + Objects.hashCode(this.DateOfBirth);
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
        final Artist other = (Artist) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Nickname, other.Nickname)) {
            return false;
        }
        if (!Objects.equals(this.DateOfBirth, other.DateOfBirth)) {
            return false;
        }
        return true;
    }
    
}
