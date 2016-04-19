/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.utils;

import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import sun.misc.BASE64Encoder;

/**
 *
 * @author John
 */
public class HashManager {
    public static String GeneratePassword(String Phrase,String Salt){
        return SHA256(Phrase + Salt);
    }
    public static String SHA256(String text){
        return DigestUtils.sha256Hex(text);
    }
    public static String GenerateStringSalt(){
        SecureRandom RANDOM = new SecureRandom();
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);
        return Base64.encodeBase64String(salt);
    }
}
