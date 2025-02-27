package api.booker.modules.auth;

import api.booker.base.BaseSpec;
import api.booker.base.Endpoints;
import api.booker.modules.auth.models.TokenResponse;
import api.booker.modules.auth.models.UserAuthRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthServiceImpl extends BaseSpec implements AuthService {
    @Override
    public TokenResponse loginUser() {
        return createSession().as(TokenResponse.class);
    }

    private Response createSession() {
        UserAuthRequest user = new UserAuthRequest(USERNAME, PASSWORD);
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