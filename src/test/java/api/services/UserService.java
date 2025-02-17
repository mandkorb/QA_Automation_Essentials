package api.services;

import api.base.BaseSpec;
import api.base.Endpoints;
import api.models.requests.UserRegisterRequest;
import api.models.responses.UserByIdResponse;
import api.models.responses.UserRegisterResponse;
import api.models.responses.UsersListResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService extends BaseSpec {
    public UserByIdResponse getUserById(int userId, boolean exists) {
        return readUserById(userId, exists).as(UserByIdResponse.class);
    }

    public UsersListResponse getUsersList(int page) {
        return readUsersListByPage(page).as(UsersListResponse.class);
    }

    public UserRegisterResponse registerUser(UserRegisterRequest user){
        return createUser(user).as(UserRegisterResponse.class);
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

    private Response createUser(UserRegisterRequest user) {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(Endpoints.REGISTER)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
