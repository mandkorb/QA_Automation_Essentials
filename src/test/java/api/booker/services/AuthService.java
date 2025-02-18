package api.booker.services;

import api.booker.base.BaseSpec;
import api.booker.base.Endpoints;
import api.booker.models.auth.TokenResponse;
import api.booker.models.auth.UserAuthRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService extends BaseSpec {
    public TokenResponse loginUser() {
        return createSession().as(TokenResponse.class);
    }

    private Response createSession() {
        UserAuthRequest user = new UserAuthRequest(username, password);
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(Endpoints.AUTH)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
