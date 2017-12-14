package com.lavax.iocDemo;

import org.springframework.stereotype.Component;

/**
 * Created by LAVAX on 2017/12/13.
 */
@Component
public class IocCtripBookingService implements IocBookingService {
    public void bookFlight() {
        System.out.println("book fight by Ctrip!");
    }
}
