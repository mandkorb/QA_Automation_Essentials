package api.services;

import api.base.BaseSpec;
import api.base.Endpoints;
import api.responses.UserResponse;
import api.responses.UsersListResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService extends BaseSpec {
    public UserResponse getUserById(int userId, boolean exists) {
        return readUserById(userId, exists).as(UserResponse.class);
    }

    public UsersListResponse getUsersList(int page) {
        return readUsersListByPage(page).as(UsersListResponse.class);
    }

    private Response readUserById(int userId, boolean exists) {
        return given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.USERS + "/{id}", userId)
                .then()
                .spec(exists ? successResponseSpec : notFoundResponseSpec)
                .extract().response();
    }

    private Response readUsersListByPage(int page) {
        return given()
                .spec(requestSpec)
                .queryParam("page", page)
                .when()
                .get(Endpoints.USERS)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
