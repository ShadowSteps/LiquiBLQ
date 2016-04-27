package com.shadows.liquiblq.client.android.activities.models;

import com.shadows.liquiblq.client.android.config.Formats;

import java.util.Date;
import java.util.UUID;

/**
 * Created by John on 25.4.2016 г..
 */
public class SongListItemModel {
    public String Name;
    public UUID Id;
    public Date DatePublished;
    public UUID Genre;

    public SongListItemModel(String name, UUID id, Date datePublished, UUID genre) {
        Name = name;
        Id = id;
        DatePublished = datePublished;
        Genre = genre;
    }

    @Override
    public String toString(){
        return "[" + Formats.Year.format(DatePublished) + "] " + Name;
    }
}
