/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.models;

import com.shadows.liquiblq.data.interfaces.dto.Album;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author John
 */
public class AlbumTableViewModel {
    private UUID Id;
    private String Name;
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

    public Date getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(Date PublishDate) {
        this.PublishDate = PublishDate;
    }

    public AlbumTableViewModel(UUID Id, String Name, Date PublishDate) {
        this.Id = Id;
        this.Name = Name;
        this.PublishDate = PublishDate;
    }
    
    public static AlbumTableViewModel FromDTO(Album DTO){
        return new AlbumTableViewModel(DTO.Id, DTO.Name, DTO.PublishDate);
    }
}
