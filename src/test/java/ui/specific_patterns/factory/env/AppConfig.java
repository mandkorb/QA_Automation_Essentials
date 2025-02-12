package ui.specific_patterns.factory.env;

public class AppConfig {
    private static final String DEFAULT_ENV = "test";

    public static String getBaseUrl() {
        String env = System.getProperty("env", DEFAULT_ENV); // Getting from Maven
        System.out.println("Running tests on: " + env.toUpperCase());
        return EnvironmentConfig.fromString(env).getBaseUrl();
    }

    public static String getAdminUsername() {
        return System.getProperty("adminUser", "admin_test");
    }
}
