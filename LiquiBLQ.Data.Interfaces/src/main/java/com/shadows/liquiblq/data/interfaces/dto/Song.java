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
public class Song {
    public UUID Id;
    public String Name;
    public UUID Genre;
    public Date PublishDate;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.Id);
        hash = 83 * hash + Objects.hashCode(this.Name);
        hash = 83 * hash + Objects.hashCode(this.Genre);
        hash = 83 * hash + Objects.hashCode(this.PublishDate);
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
        final Song other = (Song) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.Genre, other.Genre)) {
            return false;
        }
        if (!Objects.equals(this.PublishDate, other.PublishDate)) {
            return false;
        }
        return true;
    }
    
}
