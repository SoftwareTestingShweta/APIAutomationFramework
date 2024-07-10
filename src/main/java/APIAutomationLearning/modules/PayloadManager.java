package APIAutomationLearning.modules;

import APIAutomationLearning.pojos.Booking;
import APIAutomationLearning.pojos.BookingDates;
import APIAutomationLearning.pojos.BookingResponse;
import com.google.gson.Gson;

public class PayloadManager{

    Gson gson = new Gson();
    Booking booking = new Booking();

    public String createPayloadBookingAsString(){

        booking.setFirstname("Savi");
        booking.setLastname("Telka");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        String jsonPayload = gson.toJson(booking);
        return jsonPayload;

    }

    public String fullUpdatePayloadAsString(){

        booking.setFirstname("Ravi");
        booking.setLastname("Telka");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);

    }

    public BookingResponse BookingResponseJava(String responseString){
        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);

        return bookingResponse;

    }

}
