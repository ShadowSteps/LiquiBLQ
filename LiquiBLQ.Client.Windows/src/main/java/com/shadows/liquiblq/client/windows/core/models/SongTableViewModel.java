/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.models;

import com.shadows.liquiblq.data.interfaces.dto.Song;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author John
 */
public class SongTableViewModel {
    private UUID Id;
    private String Name;        
    private String GenreName;
    private Date PublishDate;

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

    public String getGenreName() {
        return GenreName;
    }

    public void setGenreName(String GenreName) {
        this.GenreName = GenreName;
    }

    public Date getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(Date PublishDate) {
        this.PublishDate = PublishDate;
    }
    
    public SongTableViewModel(UUID Id, String Name, String GenreName, Date PublishDate) {
        this.Id = Id;
        this.Name = Name;
        this.GenreName = GenreName;
        this.PublishDate = PublishDate;
    }
    
    public static SongTableViewModel FromDTO(Song DTO){
        return new SongTableViewModel(DTO.Id, DTO.Name, DTO.Genre.toString(), DTO.PublishDate);
    }
}
