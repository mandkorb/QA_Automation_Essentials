package com.basics.tests.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties properties;

    public static void load() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            throw new IllegalStateException("Configuration is not set! Call Config.load() first.");
        }
        return properties.getProperty(key);
    }
}
