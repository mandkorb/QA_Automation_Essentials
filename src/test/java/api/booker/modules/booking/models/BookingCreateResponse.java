package api.booker.modules.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingCreateResponse {
    @JsonProperty("bookingid")
    private int bookingId;
    private BookingData booking;

    public boolean areResponseDataEqualsToGiven(BookingRequest newBooking) {
        return booking.getFirstName().equals(newBooking.getFirstName())
                && booking.getLastName().equals(newBooking.getLastName())
                && booking.getTotalPrice().equals(newBooking.getTotalPrice())
                && booking.getIsDepositPaid().equals(newBooking.isDepositPaid())
                && booking.getBookingDates().getCheckIn().equals(newBooking.getBookingDates().getCheckIn())
                && booking.getBookingDates().getCheckOut().equals(newBooking.getBookingDates().getCheckOut())
                && booking.getAdditionalNeeds().equals(newBooking.getAdditionalNeeds());
    }
}
