package com.ІFNTUNG.edu.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();
    private static ConfigReader instance;

    private ConfigReader() {
    }

    public static ConfigReader get() {
        if (instance == null) {
            instance = new ConfigReader();
            try {
                properties.load(new FileInputStream("src/main/resources/config.properties"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return instance;
    }

    public String getHomePageUrl() {
        return properties.getProperty("homePageUrl");
    }

    public String getAccountSuccessPageUrl() {
        return properties.getProperty("accountSuccessPageUrl");
    }
}
