/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core;

import com.shadows.liquiblq.client.core.http.HttpRequestHandler;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import java.util.UUID;

/**
 *
 * @author John
 */
public class SongsRequestsHandler {
    public static String getAllRequest(String ApiUrl,UUID SessinKey,Integer UserId) throws HttpRequestErrorException{
        String UrlParamanters = "sessionKey="+SessinKey.toString()+"&UserId="+UserId;
        return HttpRequestHandler.sendPost(ApiUrl+"Song/getAll", UrlParamanters);
    }
    public static String getByIdRequest(String ApiUrl,UUID SessinKey,Integer UserId,UUID SongId) throws HttpRequestErrorException{
        String UrlParamanters = "sessionKey="+SessinKey.toString()+"&UserId="+UserId;
        return HttpRequestHandler.sendPost(ApiUrl+"Song/get/"+SongId.toString(), UrlParamanters);
    }
    public static String getByAlbumIdRequest(String ApiUrl,UUID SessinKey,Integer UserId,UUID SongId) throws HttpRequestErrorException{
        String UrlParamanters = "sessionKey="+SessinKey.toString()+"&UserId="+UserId;
        return HttpRequestHandler.sendPost(ApiUrl+"Song/getByAlbum/"+SongId.toString(), UrlParamanters);
    }
    public static String getStreamMusicUrl(String ApiUrl,UUID SessinKey,Integer UserId,UUID SongId){
        String UrlParamanters = "sessionKey="+SessinKey.toString()+"&UserId="+UserId;
        return ApiUrl+"Song/play/"+SongId.toString()+"?"+UrlParamanters;
    }
}
