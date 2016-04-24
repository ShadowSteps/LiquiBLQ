package com.shadows.liquiblq.client.android.activities.models;

import com.shadows.liquiblq.client.android.config.Formats;

import java.util.Date;
import java.util.UUID;

/**
 * Created by John on 25.4.2016 г..
 */
public class AlbumListItemModel{
    public String Name;
    public UUID Id;
    public Date PublishDate;

    public AlbumListItemModel(String name, UUID id, Date publishDate) {
        Name = name;
        Id = id;
        PublishDate = publishDate;
    }

    @Override
    public String toString(){
        return "Name: "+ Name + "\n" + "Date: " + Formats.Date.format(PublishDate);
    }
}
