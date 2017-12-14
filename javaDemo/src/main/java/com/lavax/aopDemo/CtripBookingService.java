package com.lavax.aopDemo;

import org.springframework.stereotype.Component;

/**
 * Created by LAVAX on 2017/12/13.
 */
@Component
public class CtripBookingService implements BookingService {
    public boolean bookFlight() {
        System.out.println("book fight by Ctrip!");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return true;
    }
}
