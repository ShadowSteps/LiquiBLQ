package com.shadows.liquiblq.client.android.core.tasks;

import com.shadows.liquiblq.client.android.core.UIHandlers.AUITaskHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsOfArtistUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsOfSongUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAllAlbumsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetArtistsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAllArtistsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAllSongsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetSongsInAlbumUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.LoginUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.RegisterUIHandler;
import com.shadows.liquiblq.client.android.core.tasks.listeners.TaskErrorListener;
import com.shadows.liquiblq.client.android.core.tasks.listeners.TaskSuccessListener;
import com.shadows.liquiblq.client.android.core.tasks.listeners.TaskStartListener;
import com.shadows.liquiblq.client.core.tasks.GetAlbumsOfArtistTask;
import com.shadows.liquiblq.client.core.tasks.GetAlbumsOfSongTask;
import com.shadows.liquiblq.client.core.tasks.GetAllAlbumsTask;
import com.shadows.liquiblq.client.core.tasks.GetAllArtistsTask;
import com.shadows.liquiblq.client.core.tasks.GetAllSongsTask;
import com.shadows.liquiblq.client.core.tasks.GetArtistsInAlbumTask;
import com.shadows.liquiblq.client.core.tasks.GetSongsInAlbumTask;
import com.shadows.liquiblq.client.core.tasks.RunnableTask;
import com.shadows.liquiblq.client.core.tasks.UserLoginTask;
import com.shadows.liquiblq.client.core.tasks.UserRegisterTask;

import java.util.UUID;

/**
 * Created by John on 24.4.2016 г..
 */
public class TasksManager {
    private String ApiUrl;

    public TasksManager(String apiUrl) {
        ApiUrl = apiUrl;
    }

    private void AddTaskEvents(RunnableTask task, AUITaskHandler handler){
        task.onStart = new TaskStartListener<>(handler);
        task.onSuccess = new TaskSuccessListener(handler);
        task.onError = new TaskErrorListener(handler);
    }
    public void StartRegisterTask(RegisterUIHandler handler, String Username, String Password, String Name){
        UserRegisterTask task = new UserRegisterTask(ApiUrl,Username,Password, Name);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }

    public void StartLoginTask(LoginUIHandler handler, String Username, String Password){
        UserLoginTask task = new UserLoginTask(ApiUrl,Username,Password);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }

    public void StartGetAllAlbumsTask(GetAllAlbumsUIHandler handler, UUID SessionKey, Integer UserId){
        GetAllAlbumsTask task = new GetAllAlbumsTask(ApiUrl,SessionKey,UserId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }

    public void StartGetAllArtistsTask(GetAllArtistsUIHandler handler, UUID SessionKey, Integer UserId){
        GetAllArtistsTask task = new GetAllArtistsTask(ApiUrl,SessionKey,UserId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }

    public void StartGetAllSongsTask(GetAllSongsUIHandler handler, UUID SessionKey, Integer UserId){
        GetAllSongsTask task = new GetAllSongsTask(ApiUrl,SessionKey,UserId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }
    public void StartGetArtistsInAlbumTask(GetArtistsInAlbumUIHandler handler, UUID SessionKey, Integer UserId,UUID AlbumId){
        GetArtistsInAlbumTask task = new GetArtistsInAlbumTask(ApiUrl,SessionKey,UserId, AlbumId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }
    public void StartGetSongsInAlbumTask(GetSongsInAlbumUIHandler handler, UUID SessionKey, Integer UserId,UUID AlbumId){
        GetSongsInAlbumTask task = new GetSongsInAlbumTask(ApiUrl,SessionKey,UserId, AlbumId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }
    public void StartGetAlbumsOfSongTask(GetAlbumsOfSongUIHandler handler, UUID SessionKey, Integer UserId,UUID AlbumId){
        GetAlbumsOfSongTask task = new GetAlbumsOfSongTask(ApiUrl,SessionKey,UserId, AlbumId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }
    public void StartGetAlbumsOfArtistTask(GetAlbumsOfArtistUIHandler handler, UUID SessionKey, Integer UserId,UUID AlbumId){
        GetAlbumsOfArtistTask task = new GetAlbumsOfArtistTask(ApiUrl,SessionKey,UserId, AlbumId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }
}
