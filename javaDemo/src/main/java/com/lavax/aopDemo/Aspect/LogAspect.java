package com.lavax.aopDemo.Aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by LAVAX on 2017/12/13.
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.lavax.aopDemo..*.bookFlight(..))")
    private void logPointCut() {

    }

    @AfterReturning(pointcut = "logPointCut()", returning = "retVal")
    public void logBookingStatus(boolean retVal) {
        if (retVal) {
            System.out.println("booking flight succeeded!");
        } else {
            System.out.println("booking flight failed!");
        }
    }

}
