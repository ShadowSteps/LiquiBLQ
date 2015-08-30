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
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[MaxLength];
        random.nextBytes(bytes);      
        String str = new String(bytes, StandardCharsets.UTF_8);
        return str;
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