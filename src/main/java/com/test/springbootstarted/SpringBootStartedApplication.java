package com.test.springbootstarted;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@Configuration
//@ComponentScan
public class SpringBootStartedApplication implements ApplicationRunner {
    @Value("${hihi}")
    String value;

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootStartedApplication.class, args);
        SpringApplication springApplication=new SpringApplication(SpringBootStartedApplication.class);
        springApplication.addListeners(new UserListener());
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(value);
    }
}
