package api.booker.modules.booking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;
import lombok.Builder;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingData {
    @JsonProperty("firstname")
    String firstName;
    @JsonProperty("lastname")
    String lastName;
    @JsonProperty("totalprice")
    Integer totalPrice;
    @JsonProperty("depositpaid")
    Boolean isDepositPaid;
    @JsonProperty("bookingdates")
    BookingDates bookingDates;
    @JsonProperty("additionalneeds")
    String additionalNeeds;

    @JsonCreator
    public BookingData(
            @JsonProperty("firstname") String firstName,
            @JsonProperty("lastname") String lastName,
            @JsonProperty("totalprice") Integer totalPrice,
            @JsonProperty("depositpaid") Boolean isDepositPaid,
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
