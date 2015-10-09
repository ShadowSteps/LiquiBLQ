/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.common.communication.json;

import java.util.UUID;

/**
 *
 * @author John
 */
public class RESTRequestMainBody extends JSONRequest{

    public RESTRequestMainBody() {
    }

    public RESTRequestMainBody(UUID sessionKey, Integer userId) {
        this.sessionKey = sessionKey;
        this.userId = userId;
    }

    public UUID getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(UUID sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UUID sessionKey;
    public Integer userId;
}
