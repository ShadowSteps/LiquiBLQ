/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets;

import com.shadows.liquiblq.data.interfaces.dto.Genre;
import com.shadows.liquiblq.data.interfaces.dto.data.GenreData;
import com.shadows.liquiblq.data.interfaces.sets.base.IManagableSet;
import com.shadows.liquiblq.data.interfaces.sets.base.IViewableSet;
import java.util.UUID;

/**
 *
 * @author John
 */
public interface IGenresSet extends IViewableSet<UUID, Genre>,
        IManagableSet<UUID, GenreData>{
    
}
