/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.dto;

import java.util.Date;

/**
 *
 * @author John
 */
public class User {
    public int Id;
    public String Email;
    public String Password;
    public String Salt;
    public String Name;
    public Date DateRegistered;
}
