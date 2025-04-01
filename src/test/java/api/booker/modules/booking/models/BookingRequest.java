package api.booker.modules.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingRequest {
    @JsonProperty("firstname")
    String firstName;
    @JsonProperty("lastname")   
    String lastName;
    @JsonProperty("totalprice")
    int totalPrice;
    @JsonProperty("depositpaid")
    boolean isDepositPaid;
    @JsonProperty("bookingdates")
    BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    String additionalNeeds;

    @JsonCreator
    public BookingRequest(
            @JsonProperty("firstname") String firstName,
            @JsonProperty("lastname") String lastName,
            @JsonProperty("totalprice") int totalPrice,
            @JsonProperty("depositpaid") boolean isDepositPaid,
            @JsonProperty("bookingdates") BookingDates bookingDates,
            @JsonProperty("additionalneeds") String additionalNeeds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPrice = totalPrice;
        this.isDepositPaid = isDepositPaid;
        this.bookingDates = bookingDates;
        this.additionalNeeds = additionalNeeds;
    }
}