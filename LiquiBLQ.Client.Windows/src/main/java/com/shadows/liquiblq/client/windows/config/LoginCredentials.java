/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.config;

import com.shadows.liquiblq.client.windows.exceptions.UserNotLoggedInException;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import com.shadows.liquiblq.common.communication.json.RESTRequestMainBody;
import java.util.UUID;

/**
 *
 * @author John
 */
public class LoginCredentials {
    public static LoginResponse LoginInfo;
    public static void setLoginInfo(LoginResponse Response){
        LoginInfo = Response;        
    }
    public static boolean isLoggedIn(){
        return LoginInfo != null
                && LoginInfo.getSessionKey() != null
                && LoginInfo.getId() != null;
    }
    public Integer GetUserId() throws UserNotLoggedInException{
        if (!isLoggedIn()){
            throw new UserNotLoggedInException();
        }
        return LoginInfo.getId();
    }
    public UUID getSessionKey() throws UserNotLoggedInException{
        if (!isLoggedIn()){
            throw new UserNotLoggedInException();
        }
        return LoginInfo.getSessionKey();
    }
}
