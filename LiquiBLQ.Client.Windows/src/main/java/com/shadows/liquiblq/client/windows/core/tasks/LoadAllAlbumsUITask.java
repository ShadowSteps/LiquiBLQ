/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.core.tasks;

import com.shadows.liquiblq.client.windows.core.DialogManager;
import com.shadows.liquiblq.client.windows.core.TableViewManager;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import javafx.concurrent.Task;

/**
 *
 * @author John
 */
public class LoadAllAlbumsUITask extends Task<Boolean>{
    private GetAllAlbumsResponse albumsRepsonse;

    public LoadAllAlbumsUITask(JSONResponse albums) {
        this.albumsRepsonse = (GetAllAlbumsResponse)albums;
    }
    
    @Override
    protected Boolean call() throws Exception {
        DialogManager.CloseLoadingDialog();
        TableViewManager.CreateTableFromAlbums(albumsRepsonse.albums);
        return true;
    }
    
}
