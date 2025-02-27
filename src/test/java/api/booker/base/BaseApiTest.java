package api.booker.base;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {
    @BeforeSuite
    public static void config() {
        RestAssured.config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 30000)
                        .setParam("http.socket.timeout", 30000));
    }
}