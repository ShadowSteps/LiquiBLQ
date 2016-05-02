package com.shadows.liquiblq.client.android.core.managers;

import android.app.Activity;
import android.content.Intent;

import com.shadows.liquiblq.client.android.activities.LoginActivity;
import com.shadows.liquiblq.client.android.activities.PlaySongActivity;
import com.shadows.liquiblq.client.android.activities.RegisterActivity;
import com.shadows.liquiblq.client.android.activities.models.SongListItemModel;
import com.shadows.liquiblq.data.interfaces.dto.Song;

/**
 * Created by John on 17.3.2016 г..
 */
public class ActivityManager {
    public static void OpenLoginActivity(Activity parent){
        parent.startActivityForResult(new Intent(parent, LoginActivity.class), 1);
    }
    public static void OpenRegisterActivity(Activity parent){
        parent.startActivityForResult(new Intent(parent, RegisterActivity.class), 1);
    }
    public static void OpenPlayActivity(Activity parent, SongListItemModel songInfo){
        Intent SongIntent = new Intent(parent, PlaySongActivity.class);
        SongIntent.putExtra("SongId" , songInfo.Id.toString());
        SongIntent.putExtra("SongName" , songInfo.Name);
        parent.startActivityForResult(SongIntent, 1);
    }
}
