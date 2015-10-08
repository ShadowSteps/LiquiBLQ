/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
/**
 *
 * @author John
 */
public class PasswordSecurityProvider {
    public static String ToSHA256(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(str.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static String GenSalt(int MaxLength){
        Random r = new Random( System.currentTimeMillis() );
        Integer Number = (1 + r.nextInt(2)) * 10000 + r.nextInt(10000);
        return Number.toString();
    }
    public static String GenPasswordHash(String Password,int SaltLength) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        String Salt = GenSalt(SaltLength);
        Password += Salt;
        return ToSHA256(Password);
    }    
    public static String GenPasswordHash(String Password,String Salt) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Password += Salt;
        return ToSHA256(Password);
    }    
}
