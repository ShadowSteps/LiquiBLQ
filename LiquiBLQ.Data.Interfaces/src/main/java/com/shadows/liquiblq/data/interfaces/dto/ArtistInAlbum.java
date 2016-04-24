/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.dto;

import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author John
 */
public class ArtistInAlbum {
    public int Id;
    public UUID Artist;
    public UUID Album;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.Id;
        hash = 37 * hash + Objects.hashCode(this.Artist);
        hash = 37 * hash + Objects.hashCode(this.Album);
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
        final ArtistInAlbum other = (ArtistInAlbum) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Artist, other.Artist)) {
            return false;
        }
        if (!Objects.equals(this.Album, other.Album)) {
            return false;
        }
        return true;
    }
    
}
