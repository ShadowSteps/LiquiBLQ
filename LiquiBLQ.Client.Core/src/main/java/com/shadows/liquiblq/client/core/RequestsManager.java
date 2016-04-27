/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core;

import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import com.shadows.liquiblq.client.core.parser.ReponseParser;
import com.shadows.liquiblq.common.communication.json.GetAlbumByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfArtistResponse;
import com.shadows.liquiblq.common.communication.json.GetAlbumsOfSongResponse;
import com.shadows.liquiblq.common.communication.json.GetAllAlbumsResponse;
import com.shadows.liquiblq.common.communication.json.GetAllSongsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistByIdResponse;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.GetAllArtistsResponse;
import com.shadows.liquiblq.common.communication.json.GetArtistsInAlbumResponse;
import com.shadows.liquiblq.common.communication.json.GetSongByIdResponse;
import com.shadows.liquiblq.common.communication.json.GetSongsInAlbumResponse;
import java.util.UUID;

/**
 *
 * @author John
 */
public class RequestsManager {    
    public static JSONResponse doLoginRequest(String ApiUrl,String Username,String Password) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = UserRequestsHandler.loginRequest(ApiUrl, Username, Password); 
        LoginResponse ReponseObject = ReponseParser.ParseLoginReponse(Response);
        return ReponseObject;
    }
    public static JSONResponse doRegisterRequest(String ApiUrl,String Username,String Password,String Name) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = UserRequestsHandler.registerRequest(ApiUrl, Username, Password, Name);
        RegisterResponse ResponseObject = ReponseParser.ParseRegisterReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetAllArtistsRequest(String ApiUrl,UUID SessionKey,Integer UserId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = ArtistRequestsHandler.getAllRequest(ApiUrl, SessionKey, UserId);
        GetAllArtistsResponse ResponseObject = ReponseParser.ParseGetAllArtistsReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetAllAlbumsRequest(String ApiUrl,UUID SessionKey,Integer UserId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = AlbumRequestsHandler.getAllRequest(ApiUrl, SessionKey, UserId);
        GetAllAlbumsResponse ResponseObject = ReponseParser.ParseGetAllAlbumsReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetAllSongsRequest(String ApiUrl,UUID SessionKey,Integer UserId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = SongsRequestsHandler.getAllRequest(ApiUrl, SessionKey, UserId);
        GetAllSongsResponse ResponseObject = ReponseParser.ParseGetAllSongsReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetArtistByIdRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID ArtistId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = ArtistRequestsHandler.getByIdRequest(ApiUrl, SessionKey, UserId, ArtistId);
        GetArtistByIdResponse ResponseObject = ReponseParser.ParseGetArtistByIdReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetSongByIdRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID SongId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = SongsRequestsHandler.getByIdRequest(ApiUrl, SessionKey, UserId, SongId);
        GetSongByIdResponse ResponseObject = ReponseParser.ParseGetSongByIdReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetAlbumByIdRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID AlbumId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = AlbumRequestsHandler.getByIdRequest(ApiUrl, SessionKey, UserId, AlbumId);
        GetAlbumByIdResponse ResponseObject = ReponseParser.ParseGetAlbumByIdReponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetSongsInAlbumRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID AlbumId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = SongsRequestsHandler.getByAlbumIdRequest(ApiUrl, SessionKey, UserId, AlbumId);
        GetSongsInAlbumResponse ResponseObject = ReponseParser.ParseGetSongsInAlbumResponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetAlbumsOfArtistRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID ArtistId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = AlbumRequestsHandler.getByArtistIdRequest(ApiUrl, SessionKey, UserId, ArtistId);
        GetAlbumsOfArtistResponse ResponseObject = ReponseParser.ParseGetAlbumsOfArtistResponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetAlbumsOfSongRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID SongId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = AlbumRequestsHandler.getBySongIdRequest(ApiUrl, SessionKey, UserId, SongId);
        GetAlbumsOfSongResponse ResponseObject = ReponseParser.ParseGetAlbumsOfSongResponse(Response);
        return ResponseObject;
    }
    public static JSONResponse doGetArtistsInAlbumRequest(String ApiUrl,UUID SessionKey,Integer UserId,UUID AlbumId) throws HttpRequestErrorException, CannotParseResponseException{
        String Response = ArtistRequestsHandler.getByAlbumIdRequest(ApiUrl, SessionKey, UserId, AlbumId);
        GetArtistsInAlbumResponse ResponseObject = ReponseParser.ParseGetArtistsInAlbumResponse(Response);
        return ResponseObject;
    }
    
}
