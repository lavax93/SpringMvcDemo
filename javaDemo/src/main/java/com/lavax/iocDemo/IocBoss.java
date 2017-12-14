package com.lavax.iocDemo;

/**
 * Created by LAVAX on 2017/12/13.
 */
public class IocBoss {
    private IocBookingService bookingService;

    public IocBoss() {
        this.bookingService = new IocQunarBookingService();
    }

    public IocBookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(IocBookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void goSomewhere() {
        bookingService.bookFlight();
    }
}
