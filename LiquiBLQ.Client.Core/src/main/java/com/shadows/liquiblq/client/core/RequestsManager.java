/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core;

import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import com.shadows.liquiblq.client.core.parser.ReponseParser;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.LoginResponse;

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
}
