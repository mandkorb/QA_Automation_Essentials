package api.reqres.services;

import api.reqres.base.BaseSpec;
import api.reqres.base.Endpoints;
import api.reqres.models.resource.ResourceListResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResourceService extends BaseSpec {
    public ResourceListResponse getResourceList() {
        return readResourceList().as(ResourceListResponse.class);
    }

    private Response readResourceList() {
        return given()
                .spec(requestSpec)
                .when()
                .get(Endpoints.RESOURCE)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
