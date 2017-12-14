package com.lavax.iocDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;


/**
 * Created by LAVAX on 2017/12/13.
 */
@Configuration
@ComponentScan
public class IocApp {
    public static void main(String[] args) {
        bossGoSomewhere();
        smartBossGoSomewhere();
    }

    static void bossGoSomewhere() {
        IocBoss boss = new IocBoss();
        boss.goSomewhere();
    }

    static void smartBossGoSomewhere() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                IocApp.class);
        try {
            IocSmartBoss boss = context.getBean(IocSmartBoss.class);
            boss.goSomewhere();
        } finally {
            context.close();
        }
    }
}
