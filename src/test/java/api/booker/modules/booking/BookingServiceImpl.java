package api.booker.modules.booking;

import api.booker.base.BaseSpec;
import api.booker.base.Endpoints;
import api.booker.modules.booking.models.BookingCreateResponse;
import api.booker.modules.booking.models.BookingRequest;
import api.booker.modules.booking.models.BookingData;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingServiceImpl extends BaseSpec implements BookingService {
    @Override
    public BookingData getBookingById(int id) {
        return readBookingById(id).as(BookingData.class);
    }

    @Override
    public BookingCreateResponse createBooking(BookingRequest booking) {
        return createNewBooking(booking).as(BookingCreateResponse.class);
    }

    private Response readBookingById(int id) {
        return given()
                .spec(requestAuthSpec)
                .when()
                .get(Endpoints.BOOKING + "/{id}", id)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }

    private Response createNewBooking(BookingRequest booking) {
        return given()
                .spec(requestSpec)
                .body(booking)
                .when()
                .post(Endpoints.BOOKING)
                .then()
                .spec(successResponseSpec)
                .extract().response();
    }
}
