/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.sets;

import com.shadows.liquiblq.data.interfaces.dto.ArtistInAlbum;
import com.shadows.liquiblq.data.interfaces.dto.data.ArtistInAlbumData;
import com.shadows.liquiblq.data.interfaces.sets.base.IManagableSet;
import com.shadows.liquiblq.data.interfaces.sets.base.IViewableSet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author John
 */
public interface IArtistsInAlbumsSet extends IManagableSet<Integer, ArtistInAlbumData>,
        IViewableSet<Integer, ArtistInAlbum>{
    public List<ArtistInAlbum> GetByAlbumId(UUID Id) throws Exception;
    public List<ArtistInAlbum> GetByArtistId(UUID Id) throws Exception;
}
