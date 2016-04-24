/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.models;

import com.shadows.liquiblq.data.interfaces.dto.Artist;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author John
 */
public class ArtistTableViewModel {
    private UUID Id;
    private String Name;
    private String Nickname;
    private Date DateOfBirth;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public ArtistTableViewModel(UUID Id, String Name, String Nickname, Date DateOfBirth) {
        this.Id = Id;
        this.Name = Name;
        this.Nickname = Nickname;
        this.DateOfBirth = DateOfBirth;
    }
            
    public static ArtistTableViewModel FromDTO(Artist DTO){
        return new ArtistTableViewModel(DTO.Id, DTO.Name, DTO.Nickname, DTO.DateOfBirth);
    }
}
