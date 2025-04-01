package api.booker.modules.booking.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookingDates {
    @JsonProperty("checkin")
    String checkIn;
    @JsonProperty("checkout")
    String checkOut;

    @JsonCreator
    public BookingDates(
            @JsonProperty("checkin") String checkIn,
            @JsonProperty("checkout") String checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
}
