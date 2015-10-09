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
public class ArtistRequestsHandler {
    public static String getAllRequest(String ApiUrl,UUID SessinKey,Integer UserId) throws HttpRequestErrorException{
        String UrlParamanters = "SessionKey="+SessinKey.toString()+"&UserId="+UserId;
        return HttpRequestHandler.sendPost(ApiUrl+"artists/getAll", UrlParamanters);
    }
    public static String getByIdRequest(String ApiUrl,UUID SessinKey,Integer UserId,UUID ArtistId) throws HttpRequestErrorException{
        String UrlParamanters = "SessionKey="+SessinKey.toString()+"&UserId="+UserId;
        return HttpRequestHandler.sendPost(ApiUrl+"artists/getById/"+ArtistId.toString(), UrlParamanters);
    }
}
