/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

/**
 *
 * @author John
 */
public class RegisterResponse extends JSONResponse{
    public RegisterResponse(Boolean status, Integer id, String email) {
        this.status = status;
        this.id = id;
        this.email = email;
    }   
    public Boolean status;
    public Integer id;
    public String email;
}
