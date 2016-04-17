/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets;

import com.shadows.liquiblq.data.interfaces.dto.SongInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.data.SongInAlbumData;
import com.shadows.liquiblq.data.interfaces.sets.base.IManagableSet;
import com.shadows.liquiblq.data.interfaces.sets.base.IViewableSet;

/**
 *
 * @author John
 */
public interface ISongsInAlbumsSet extends IViewableSet<Integer, SongInAlbum>,
        IManagableSet<Integer, SongInAlbumData>{
    
}
