package com.lavax.aopDemo;

/**
 * Created by LAVAX on 2017/12/13.
 */
public class QunarBookingService implements BookingService {

    public boolean bookFlight() {
        System.out.println("book fight by Qunar!");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }
}
