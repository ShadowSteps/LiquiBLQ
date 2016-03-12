package com.shadows.liquiblq.common.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author John
 */
public class StringValidator {
    public static Boolean Between(String str,int Min,int Max){
        return (str.length()>= Min && str.length() <= Max);
    }
}
