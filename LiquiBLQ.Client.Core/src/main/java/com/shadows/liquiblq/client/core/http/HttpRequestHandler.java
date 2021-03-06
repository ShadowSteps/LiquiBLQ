/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.core.http;

import com.shadows.liquiblq.client.core.http.exceptions.HttpRequestErrorException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class HttpRequestHandler {
    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        URLConnection con = (URLConnection) obj.openConnection();
        con.setDoInput(true);
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        InputStream is = null;
        for (int i = 0; i < 4; i++) {
            try {
                is = con.getInputStream();
                break;
            } catch (IOException Ex) {
                Thread.sleep(2000);
                int attemptNum = i + 1;
            }
        }
        if (is == null) {
            throw new HttpRequestErrorException("HttpRequest:Invalid Responce from the server.");
        }
        StringBuilder response = new StringBuilder();
        int read;
        while ((read = is.read()) != -1) {
            response.append((char) read);
        }
        is.close();
        return (response.toString());
    }

    public static String sendPost(String url, String urlParameters) throws HttpRequestErrorException {
        try {
            URL obj = new URL(url);
            URLConnection con = (URLConnection) obj.openConnection();
            con.setRequestProperty("Accept-Language","en-US,en;q=0.5");
            con.setDoOutput(true);
            con.setDoInput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            InputStream is = null;
            for (int i = 0; i < 4; i++) {
                try {
                    is = con.getInputStream();
                    break;
                } catch (IOException Ex) {
                    Thread.sleep(2000);
                    int attemptNum = i + 1;
                }
            }
            if (is == null) {
                throw new HttpRequestErrorException("HttpRequest:Invalid Responce from the server.");
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (IOException | InterruptedException | HttpRequestErrorException ex) {
            throw new HttpRequestErrorException(ex.getMessage());
        }
    }
}
