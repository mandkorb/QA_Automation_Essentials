package api.booker.modules.booking;

import api.booker.modules.booking.models.BookingResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class BookingServiceTests {
    private BookingService bookingService;
    private final int BOOKING_ID = 1;

    @BeforeClass
    public void setup() {
        bookingService = new BookingService();
    }

    @Test
    public void returnBookingsDataById() {
        BookingResponse bookings = bookingService.getBooking(BOOKING_ID);
        assertNotNull(bookings);
    }
}
