package com.test.springbootstarted;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;

public class UserListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("UserListener"+event.toString());
    }
}
