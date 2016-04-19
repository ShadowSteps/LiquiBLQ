/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.hibernate;

import com.shadows.liquiblq.data.hibernate.sets.*;
import com.shadows.liquiblq.data.interfaces.ILiquiBlqContext;
import com.shadows.liquiblq.data.interfaces.sets.*;

/**
 *
 * @author John
 */
public class LiquiBlqContext implements ILiquiBlqContext{
    private IAlbumsSet AlbumsSet;
    private IArtistsInAlbumsSet ArtistsInAlbumsSet;
    private IArtistsSet ArtistsSet;
    private IGenresSet GenresSet;
    private ISessionsSet SessionsSet;
    private ISongsInAlbumsSet SongsInAlbumsSet;
    private ISongsSet SongsSet;
    private IUsersSet UsersSet;

    public LiquiBlqContext() {
        AlbumsSet = new AlbumsSet();
        ArtistsInAlbumsSet = new ArtistsInAlbumsSet();
        ArtistsSet = new ArtistsSet();
        GenresSet = new GenresSet();
        SessionsSet = new SessionsSet();
        SongsInAlbumsSet = new SongsInAlbumsSet();
        SongsSet = new SongsSet();
        UsersSet = new UsersSet();
    }
        
    @Override
    public IAlbumsSet getAlbumsSet() {
        return AlbumsSet;
    }

    @Override
    public IArtistsInAlbumsSet getArtistsInAlbumsSet() {
        return ArtistsInAlbumsSet;
    }

    @Override
    public IArtistsSet getArtistsSet() {
        return ArtistsSet;
    }

    @Override
    public IGenresSet getGenresSet() {
        return GenresSet;
    }

    @Override
    public ISessionsSet getSessionsSet() {
        return SessionsSet;
    }

    @Override
    public ISongsInAlbumsSet getSongsInAlbumsSet() {
        return SongsInAlbumsSet;
    }

    @Override
    public ISongsSet getSongsSet() {
        return SongsSet;
    }

    @Override
    public IUsersSet getUsersSet() {
        return UsersSet;
    }
    
}
