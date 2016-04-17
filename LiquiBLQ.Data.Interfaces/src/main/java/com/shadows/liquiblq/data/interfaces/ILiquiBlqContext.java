/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces;

import com.shadows.liquiblq.data.interfaces.sets.IAlbumsSet;
import com.shadows.liquiblq.data.interfaces.sets.IArtistsInAlbumsSet;
import com.shadows.liquiblq.data.interfaces.sets.IArtistsSet;
import com.shadows.liquiblq.data.interfaces.sets.IGenresSet;
import com.shadows.liquiblq.data.interfaces.sets.ISessionsSet;
import com.shadows.liquiblq.data.interfaces.sets.ISongsInAlbumsSet;
import com.shadows.liquiblq.data.interfaces.sets.ISongsSet;
import com.shadows.liquiblq.data.interfaces.sets.IUsersSet;

/**
 *
 * @author John
 */
public interface ILiquiBlqContext {
   public IAlbumsSet getAlbumsSet();
   public IArtistsInAlbumsSet getArtistsInAlbumsSet();
   public IArtistsSet getArtistsSet();
   public IGenresSet getGenresSet();
   public ISessionsSet getSessionsSet();
   public ISongsInAlbumsSet getSongsInAlbumsSet();
   public ISongsSet getSongsSet();
   public IUsersSet getUsersSet();
}
