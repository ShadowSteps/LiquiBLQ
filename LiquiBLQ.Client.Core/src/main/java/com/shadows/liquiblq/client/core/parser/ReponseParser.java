/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.parser;

import com.shadows.liquiblq.common.communication.json.LoginResponse;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shadows.liquiblq.client.core.http.exceptions.CannotParseResponseException;
import com.shadows.liquiblq.common.communication.json.JSONResponse;
import com.shadows.liquiblq.common.communication.json.RegisterResponse;
import com.shadows.liquiblq.common.communication.json.artistResponse;
import java.io.IOException;
/**
 *
 * @author John
 */
public class ReponseParser {
    protected static JSONResponse parse(String Response,Class Type) throws CannotParseResponseException{
        ObjectMapper mapper = new ObjectMapper();
        Object ResponseObject = null;
        try {                    
            ResponseObject = mapper.readValue(Response, Type);
        } catch (JsonGenerationException | JsonMappingException e) {
            throw new CannotParseResponseException(e.getMessage());
        } catch (IOException e) {
            throw new CannotParseResponseException(e.getMessage());
        } 
        return (JSONResponse)ResponseObject;
    }
    public static LoginResponse ParseLoginReponse(String Reponse) throws CannotParseResponseException{                
        return (LoginResponse)parse(Reponse, LoginResponse.class);
    }
    public static RegisterResponse ParseRegisterReponse(String Reponse) throws CannotParseResponseException{        
        return (RegisterResponse)parse(Reponse, RegisterResponse.class);
    }
    public static artistResponse ParseGetAllArtistsReponse(String Reponse) throws CannotParseResponseException{        
        return (artistResponse)parse(Reponse, artistResponse.class);
    }
}
