package com.lavax.aopDemo;

/**
 * Created by LAVAX on 2017/12/13.
 */
public class Boss {
    private BookingService bookingService;

    public Boss() {
        this.bookingService = new QunarBookingService();
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public void goSomewhere() {
        long start = System.currentTimeMillis();
        boolean status = bookingService.bookFlight();

        //查看耗时
        long duration = System.currentTimeMillis() - start;
        System.out.println(String.format("time for boss booking flight is %d seconds", duration));

        //记录日志
        if (status) {
            System.out.println("boss booking flight succeeded!");
        } else {
            System.out.println("boss booking flight failed!");
        }
    }
}
