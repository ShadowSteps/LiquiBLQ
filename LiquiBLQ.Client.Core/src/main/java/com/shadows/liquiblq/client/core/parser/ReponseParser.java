/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.parser;

import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfArtistResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfSongResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistsInAlbumResponse;
import com.shadows.liquiblq.common.communication.json.GetSongByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetSongsInAlbumResponse;
import java.io.IOException;
/**
 *
 * @author John
 */
public class ReponseParser {
    protected static JSONResponse parse(String Response,Class Type) throws CannotParseResponseException{
        ObjectMapper mapper = new ObjectMapper();
        Object ResponseObject = null;
        try {                    
            ResponseObject = mapper.readValue(Response, Type);
        } catch (JsonGenerationException | JsonMappingException e) {
            throw new CannotParseResponseException(e.getMessage());
        } catch (IOException e) {
            throw new CannotParseResponseException(e.getMessage());
        } 
        return (JSONResponse)ResponseObject;
    }
    public static LoginResponse ParseLoginReponse(String Reponse) throws CannotParseResponseException{                
        return (LoginResponse)parse(Reponse, LoginResponse.class);
    }
    public static RegisterResponse ParseRegisterReponse(String Reponse) throws CannotParseResponseException{        
        return (RegisterResponse)parse(Reponse, RegisterResponse.class);
    }
    public static GetAllArtistsResponse ParseGetAllArtistsReponse(String Reponse) throws CannotParseResponseException{        
        return (GetAllArtistsResponse)parse(Reponse, GetAllArtistsResponse.class);
    }
    public static GetAllAlbumsResponse ParseGetAllAlbumsReponse(String Reponse) throws CannotParseResponseException{        
        return (GetAllAlbumsResponse)parse(Reponse, GetAllAlbumsResponse.class);
    }
    public static GetAllSongsResponse ParseGetAllSongsReponse(String Reponse) throws CannotParseResponseException{        
        return (GetAllSongsResponse)parse(Reponse, GetAllSongsResponse.class);
    }
    public static GetAlbumByIdResponse ParseGetAlbumByIdReponse(String Reponse) throws CannotParseResponseException{        
        return (GetAlbumByIdResponse)parse(Reponse, GetAlbumByIdResponse.class);
    }
    public static GetSongByIdResponse ParseGetSongByIdReponse(String Reponse) throws CannotParseResponseException{        
        return (GetSongByIdResponse)parse(Reponse, GetSongByIdResponse.class);
    }
    public static GetArtistByIdResponse ParseGetArtistByIdReponse(String Reponse) throws CannotParseResponseException{        
        return (GetArtistByIdResponse)parse(Reponse, GetArtistByIdResponse.class);
    }
    public static GetSongsInAlbumResponse ParseGetSongsInAlbumResponse(String Reponse) throws CannotParseResponseException{        
        return (GetSongsInAlbumResponse)parse(Reponse, GetSongsInAlbumResponse.class);
    }
    public static GetAlbumsOfArtistResponse ParseGetAlbumsOfArtistResponse(String Reponse) throws CannotParseResponseException{        
        return (GetAlbumsOfArtistResponse)parse(Reponse, GetAlbumsOfArtistResponse.class);
    }
    public static GetAlbumsOfSongResponse ParseGetAlbumsOfSongResponse(String Reponse) throws CannotParseResponseException{        
        return (GetAlbumsOfSongResponse)parse(Reponse, GetAlbumsOfSongResponse.class);
    }
    public static GetArtistsInAlbumResponse ParseGetArtistsInAlbumResponse(String Reponse) throws CannotParseResponseException{        
        return (GetArtistsInAlbumResponse)parse(Reponse, GetArtistsInAlbumResponse.class);
    }
}
