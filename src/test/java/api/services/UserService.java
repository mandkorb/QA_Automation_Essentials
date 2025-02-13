package api.services;

import api.base.BaseSpec;
import api.base.Endpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService extends BaseSpec {
    public Response getExistingUserById(int userId) {
        return given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.USERS + "/{id}", userId)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }

    public Response getNotExistingUserById(int userId) {
        return given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.USERS + "/{id}", userId)
                .then()
                .spec(notFoundResponseSpec)
                .extract().response();
    }
}
