package com.shadows.liquiblq.client.android.config;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by John on 24.4.2016 г..
 */
public class LoginSession {
    public static UUID sessionKey;
    public static Integer UserId;
    public static String Email;

    public static boolean IsLoggedIn(){
        return (sessionKey!=null&&
                UserId!=null&&
                !Objects.equals(sessionKey,UUID.fromString("00000000-0000-0000-0000-000000000000"))&&
                UserId>0
        );
    }
}
