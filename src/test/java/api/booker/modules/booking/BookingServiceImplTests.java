package api.booker.modules.booking;

import api.booker.base.BaseApiTest;
import api.booker.modules.booking.models.BookingCreateResponse;
import api.booker.modules.booking.models.BookingDates;
import api.booker.modules.booking.models.BookingRequest;
import api.booker.modules.booking.models.BookingData;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BookingServiceImplTests extends BaseApiTest {
    private BookingServiceImpl bookingServiceImpl;
    private final int BOOKING_ID = 1;

    @BeforeClass
    public void setup() {
        bookingServiceImpl = new BookingServiceImpl();
    }

    @Test
    public void returnBookingsDataById() {
        BookingData booking = bookingServiceImpl.getBookingById(BOOKING_ID);
        assertNotNull(booking);
    }

    @Test(dataProvider = "validBookingData")
    public void returnBookingWhenCreated(String firstName, String lastName, int totalPrice, boolean isDepositPaid, String checkIn, String checkOut, String additionalNeeds) {
        BookingDates bookingDates = BookingDates.builder()
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();

        BookingRequest booking = BookingRequest.builder()
                .firstName(firstName)
                .lastName(lastName)
                .totalPrice(totalPrice)
                .isDepositPaid(isDepositPaid)
                .bookingDates(bookingDates)
                .additionalNeeds(additionalNeeds)
                .build();
        BookingCreateResponse response = bookingServiceImpl.createBooking(booking);
        assertNotNull(response);
        assertTrue(response.areResponseDataEqualsToGiven(booking));
    }

    @DataProvider(name = "validBookingData")
    public Object[][] provideValidBookingData() {
        return new Object[][]{
                {"Jim", "Browns", 111, true, "2018-01-01", "2019-01-01", "Breakfest"},
                {"", "", 0, false, "2018-01-01", "2019-01-01", ""},
        };
    }
}
