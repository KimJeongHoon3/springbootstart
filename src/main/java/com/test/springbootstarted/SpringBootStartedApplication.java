package com.test.springbootstarted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@ComponentScan
public class SpringBootStartedApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootStartedApplication.class, args);
        SpringApplication springApplication=new SpringApplication(SpringBootStartedApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

}
