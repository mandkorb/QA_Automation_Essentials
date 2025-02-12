package ui.specific_patterns.factory.env;

import java.util.Arrays;

public enum EnvironmentConfig {
    TEST("test", "https://test.myapp.com"),
    STAGE("stage", "https://stage.myapp.com"),
    PROD("prod", "https://prod.myapp.com");

    private final String name;
    private final String baseUrl;

    EnvironmentConfig(String name, String baseUrl) {
        this.name = name;
        this.baseUrl = baseUrl;
    }

    public static EnvironmentConfig fromString(String envName) {
        for (EnvironmentConfig env : values()) {
            if (env.name.equalsIgnoreCase(envName)) {
                return env;
            }
        }
        throw new IllegalArgumentException("Unknown environment: " + envName
                + ". Acceptable: " + Arrays.toString(values()));
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
