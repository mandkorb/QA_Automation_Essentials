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
                {"John", "Smith", 999, true, "2023-12-01", "2024-01-15", "Late checkout"},
                {"Maria", "Garcia", 450, true, "2023-11-15", "2023-11-20", "Extra bed"},
                {"David", "Johnson", 780, true, "2024-02-01", "2024-02-10", "Airport transfer"},
                {"Emma", "Wilson", 325, false, "2023-12-24", "2023-12-26", "Christmas dinner"},
                {"Michael", "Taylor", 550, true, "2024-03-15", "2024-03-20", "Spa access"},
                {"Sarah", "Anderson", 890, true, "2024-01-05", "2024-01-15", "All inclusive"},
                {"Robert", "Martinez", 275, false, "2023-11-30", "2023-12-02", "Early check-in"},
                {"Lisa", "Thomas", 660, true, "2024-04-01", "2024-04-07", "Business center"},
                {"James", "White", 445, true, "2024-02-14", "2024-02-16", "Valentine's package"},
                {"Anna", "Brown", 925, true, "2024-05-20", "2024-05-30", "Ocean view room"},
                {"Kevin", "Miller", 550, false, "2024-03-01", "2024-03-05", "Conference room"}
        };
    }
}
