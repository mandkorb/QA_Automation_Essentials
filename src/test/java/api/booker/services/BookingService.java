package api.booker.services;

import api.booker.base.BaseSpec;
import api.booker.base.Endpoints;
import api.booker.models.booking.BookingResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingService extends BaseSpec {
    public BookingResponse getBooking(int id) {
        return readBooking(id).as(BookingResponse.class);
    }

    private Response readBooking(int id) {
        return given()
                .spec(requestAuthSpec)
                .when()
                .get(Endpoints.BOOKING + "/{id}}", id)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
