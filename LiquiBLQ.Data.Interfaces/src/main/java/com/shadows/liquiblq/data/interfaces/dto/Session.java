/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.data.interfaces.dto;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author John
 */
public class Session {
    public UUID Id;
    public int UserId;
    public boolean IsActive;
    public Date DateCreated;
}
