/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.config;

import com.shadows.liquiblq.client.windows.exceptions.UserNotLoggedInException;
import com.shadows.liquiblq.common.communication.json.LoginResponse;
import java.util.UUID;

/**
 *
 * @author John
 */
public class LoginCredentials {
    private static LoginResponse LoginInfo;
    public static void setLoginInfo(LoginResponse Response){
        LoginInfo = Response;        
    }
    public static boolean isLoggedIn(){
        return LoginInfo != null
                && LoginInfo.sessionKey != null
                && LoginInfo.id != null;
    }
    public static Integer GetUserId() throws UserNotLoggedInException{
        if (!isLoggedIn()){
            throw new UserNotLoggedInException();
        }
        return LoginInfo.id;
    }
    public static UUID getSessionKey() throws UserNotLoggedInException{
        if (!isLoggedIn()){
            throw new UserNotLoggedInException();
        }
        return LoginInfo.sessionKey;
    }
}
