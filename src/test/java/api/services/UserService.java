package api.services;

import api.base.BaseSpec;
import api.base.Endpoints;
import api.models.register.invalid.UserRegisterInvalidRequest;
import api.models.register.invalid.UserRegisterInvalidResponse;
import api.models.register.valid.UserRegisterValidRequest;
import api.models.get_users.UserByIdResponse;
import api.models.register.valid.UserRegisterValidResponse;
import api.models.get_users.UsersListResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService extends BaseSpec {
    public UserByIdResponse getUserById(int userId, boolean exists) {
        return readUserById(userId, exists).as(UserByIdResponse.class);
    }

    public UsersListResponse getUsersList(int page) {
        return readUsersListByPage(page).as(UsersListResponse.class);
    }

    public UserRegisterValidResponse registerUser(UserRegisterValidRequest user) {
        return createUser(user).as(UserRegisterValidResponse.class);
    }

    public UserRegisterInvalidResponse attemptInvalidRegistration(UserRegisterInvalidRequest user) {
        return createInvalidRegisterAttempt(user).as(UserRegisterInvalidResponse.class);
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

    private Response createUser(UserRegisterValidRequest user) {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(Endpoints.REGISTER)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }

    private Response createInvalidRegisterAttempt(UserRegisterInvalidRequest user) {
        return given()
                .spec(requestSpec)
                .body(user)
                .when()
                .post(Endpoints.REGISTER)
                .then()
                .spec(badRequestResponseSpec)
                .extract().response();
    }
}
