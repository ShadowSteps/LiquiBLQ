/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core;

import com.shadows.liquiblq.client.core.http.HttpRequestHandler;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;

/**
 *
 * @author John
 */
public class UserRequestsHandler {
    public static String loginRequest(String ApiUrl,String Username,String Password) throws  HttpRequestErrorException{  
        String UrlParamanters = "Email="+Username+"&Password="+Password;
        return HttpRequestHandler.sendPost(ApiUrl+"user/login", UrlParamanters);
    }
}
