package com.lavax.iocDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LAVAX on 2017/12/13.
 */
@Component
public class IocSmartBoss {
    private IocBookingService bookingService;

    @Autowired
    public void setBookingService(IocBookingService bookingService) {
        this.bookingService = bookingService;
    }

    public IocBookingService getBookingService() {
        return bookingService;
    }

    public void goSomewhere() {
        bookingService.bookFlight();
    }
}
