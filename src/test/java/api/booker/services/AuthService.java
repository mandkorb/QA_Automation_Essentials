package api.booker.services;

import api.booker.base.BaseSpec;
import api.booker.base.Endpoints;
import api.booker.models.auth.TokenResponse;
import api.booker.models.auth.UserAuthRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService extends BaseSpec {
    private UserAuthRequest user;

    public TokenResponse loginUser() {
        user = new UserAuthRequest(USERNAME, PASSWORD);
        return createSession().as(TokenResponse.class);
    }

    private Response createSession() {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(Endpoints.AUTH)
                .then()
                .log().all()
                .spec(successResponseSpec)
                .extract().response();
    }
}
