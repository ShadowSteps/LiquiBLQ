package com.shadows.liquiblq.client.android.core.tasks;

import com.shadows.liquiblq.client.android.core.UIHandlers.AUITaskHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.GetAlbumsUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.LoginUIHandler;
import com.shadows.liquiblq.client.android.core.UIHandlers.RegisterUIHandler;
import com.shadows.liquiblq.client.android.core.tasks.listeners.TaskErrorListener;
import com.shadows.liquiblq.client.android.core.tasks.listeners.TaskSuccessListener;
import com.shadows.liquiblq.client.android.core.tasks.listeners.TaskStartListener;
import com.shadows.liquiblq.client.core.tasks.GetAllAlbumsTask;
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

    public void StartGetAllAlbumsTask(GetAlbumsUIHandler handler, UUID SessionKey, Integer UserId){
        GetAllAlbumsTask task = new GetAllAlbumsTask(ApiUrl,SessionKey,UserId);
        AddTaskEvents(task,handler);
        new Thread(task).start();
    }
}
