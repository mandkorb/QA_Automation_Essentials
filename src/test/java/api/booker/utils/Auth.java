package api.booker.utils;

import api.booker.base.Endpoints;
import api.booker.models.auth.TokenResponse;
import api.booker.models.auth.UserAuthRequest;
import config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Auth {
    private static final String USERNAME = Configuration.getProperty("booker.username");
    private static final String PASSWORD = Configuration.getProperty("booker.password");
    private static final ThreadLocal<String> token = new ThreadLocal<>();

    public static String getToken() {
        if (token.get() == null || isTokenExpired()) {
            String newToken = fetchNewToken();
            token.set(newToken);
            Configuration.setProperty("booker.token", newToken);
        }
        return token.get();
    }

    private static String fetchNewToken() {
        UserAuthRequest user = new UserAuthRequest(USERNAME, PASSWORD);
        return given()
                    .baseUri(Configuration.getProperty("booker.url"))
                    .contentType(ContentType.JSON)
                    .body(user)
                .when()
                    .post(Endpoints.AUTH)
                .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .time(lessThan(5L), TimeUnit.SECONDS)
                    .extract()
                    .as(TokenResponse.class)
                    .getToken();
    }

    private static boolean isTokenExpired() {
        //TODO
        return false;
    }
}
