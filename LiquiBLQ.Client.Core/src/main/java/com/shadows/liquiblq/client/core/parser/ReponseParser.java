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
import java.io.IOException;
/**
 *
 * @author John
 */
public class ReponseParser {
    public static LoginResponse ParseLoginReponse(String Reponse) throws CannotParseResponseException{        
        ObjectMapper mapper = new ObjectMapper();
        LoginResponse ResponseObject = null;
        try {                    
            ResponseObject = mapper.readValue(Reponse, LoginResponse.class);
        } catch (JsonGenerationException | JsonMappingException e) {
            throw new CannotParseResponseException(e.getMessage());
        } catch (IOException e) {
            throw new CannotParseResponseException(e.getMessage());
        } 
        return ResponseObject;
    }
}
