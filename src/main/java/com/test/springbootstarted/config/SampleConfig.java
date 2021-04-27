package com.test.springbootstarted.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
@Profile("testdb")
public class SampleConfig {
    @Value("${hihi}")
    String hihi;

    public boolean isOk(){
        System.out.println(hihi);
        return true;
    }
}
