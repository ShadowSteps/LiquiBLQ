package com.shadows.liquiblq.client.android.activities.models;

import com.shadows.liquiblq.client.android.config.Formats;

import java.util.Date;
import java.util.UUID;

/**
 * Created by John on 25.4.2016 г..
 */
public class ArtistListItemModel {
    public String Name;
    public String Nickname;
    public UUID Id;
    public Date DateOfBirth;

    public ArtistListItemModel(String name, UUID id, Date dateOfBirth, String nickname) {
        Name = name;
        Id = id;
        DateOfBirth = dateOfBirth;
        Nickname = nickname;
    }

    @Override
    public String toString(){
        return Name + (Nickname.length() > 0 ?  " aka " + Nickname : "");
    }
}
