package api.booker.base;

import api.booker.modules.auth.models.TokenResponse;
import api.booker.modules.auth.models.UserAuthRequest;
import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BaseSpec {
    private static final String BASE_URL = Configuration.getProperty("booker.url");
    protected static final String USERNAME = Configuration.getProperty("booker.username");
    protected static final String PASSWORD = Configuration.getProperty("booker.password");
    protected RequestSpecification requestAuthSpec;
    private String token;

    protected static final RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();;
    protected static final ResponseSpecification successResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
            .build();;

    public BaseSpec() {
        requestAuthSpec = new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }

    public String getToken() {
        if (token == null) {
            token = fetchNewToken();
        }
        return token;
    }

    private String fetchNewToken() {
        UserAuthRequest user = new UserAuthRequest(USERNAME, PASSWORD);
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(Endpoints.AUTH)
                .then()
                .spec(successResponseSpec)
                .extract()
                .as(TokenResponse.class)
                .getToken();
    }
}
