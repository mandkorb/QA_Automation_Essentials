package api.booker.modules.booking;

import api.booker.modules.booking.models.BookingCreateResponse;
import api.booker.modules.booking.models.BookingData;
import api.booker.modules.booking.models.BookingRequest;

public interface BookingService {
    BookingData getBookingById(int id);
    BookingCreateResponse createBooking(BookingRequest booking);
}
