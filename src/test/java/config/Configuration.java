package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            throw new IllegalStateException("Configuration load failed!");
        }
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        if (properties == null) {
            throw new IllegalStateException("Configuration load failed!");
        }
        properties.setProperty(key, value);
    }
}
