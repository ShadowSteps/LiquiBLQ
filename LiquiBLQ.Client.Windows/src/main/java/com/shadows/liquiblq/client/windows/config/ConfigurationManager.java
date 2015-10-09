/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadows.liquiblq.client.windows.config;

import com.shadows.liquiblq.client.windows.exceptions.ApplicationConfigurationException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author John
 */
public class ConfigurationManager {
    public static AppConfig GetApplicationConfiguration() throws ApplicationConfigurationException{
        try {
            JAXBContext context = JAXBContext
                    .newInstance(AppConfig.class);
            Unmarshaller um = context.createUnmarshaller();
            AppConfig wrapper = (AppConfig) um.unmarshal(ConfigurationManager.class.getResource("/config/windows/appConfig.xml"));
            return wrapper;
        } catch (Exception e) {
            throw new ApplicationConfigurationException("Application was not configurated properly!", e);
        }
    }
    public static String GetApiUrl() throws ApplicationConfigurationException{
        AppConfig conf = ConfigurationManager.GetApplicationConfiguration();
        String ApiUrl = conf.getApiUrl();
        return ApiUrl;
    }
}
