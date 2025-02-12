package api.services;

import api.spec.BaseSpec;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService extends BaseSpec {
    public Response getUserById(int userId) {
        return given()
                .spec(requestSpec)
                .get("/users/" + userId)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
