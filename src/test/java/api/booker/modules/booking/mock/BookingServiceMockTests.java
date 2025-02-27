package api.booker.modules.booking.mock;

import api.booker.modules.booking.BookingService;
import api.booker.modules.booking.models.BookingData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class BookingServiceMockTests {
    @Test
    public void testBookingMock() {
        BookingService mockService = mock(BookingService.class);

        BookingData mockBookingData = BookingData.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        when(mockService.getBookingById(anyInt())).thenReturn(mockBookingData);

        BookingData bookingData = mockService.getBookingById(5);
        Assert.assertEquals(bookingData.getFirstName(), "John");
        Assert.assertEquals(bookingData.getLastName(), "Doe");
    }
}
