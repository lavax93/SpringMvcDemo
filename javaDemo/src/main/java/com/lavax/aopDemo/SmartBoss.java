package com.lavax.aopDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LAVAX on 2017/12/13.
 */
@Component
public class SmartBoss {
    private BookingService bookingService;

    @Autowired
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void goSomewhere() {
        bookingService.bookFlight();
    }
}
