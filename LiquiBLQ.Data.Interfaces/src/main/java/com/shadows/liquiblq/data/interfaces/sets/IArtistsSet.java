/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets;

import com.shadows.liquiblq.data.interfaces.dto.Artist;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistData;
import com.shadows.liquiblq.data.interfaces.sets.base.IManagableSet;
import com.shadows.liquiblq.data.interfaces.sets.base.IViewableSet;
import java.util.UUID;

/**
 *
 * @author John
 */
public interface IArtistsSet extends IViewableSet<UUID, Artist>,
        IManagableSet<UUID, ArtistData>{
    
}
