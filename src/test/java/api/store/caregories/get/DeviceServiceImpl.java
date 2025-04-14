package api.store.caregories.get;

import static io.restassured.RestAssured.given;

import api.store.base.BaseService;
import api.store.base.Endpoints;
import api.store.models.device_list.DeviceResponse;
import io.restassured.response.Response;
import java.util.List;

public class DeviceServiceImpl extends BaseService implements DeviceService {
    @Override
    public List<DeviceResponse> getAllDevices() {
        return fetchDevicesResponse()
                .then()
                .extract()
                .jsonPath()
                .getList(".", DeviceResponse.class);
    }

    private Response fetchDevicesResponse() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .when()
                .get(Endpoints.OBJECTS)
                .then()
                .log().all()
                .spec(RESPONSE_SPECIFICATION)
                .extract().response();
    }
}
