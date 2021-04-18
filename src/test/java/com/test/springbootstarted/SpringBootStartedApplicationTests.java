package com.test.springbootstarted;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:/test.properties")
class SpringBootStartedApplicationTests {

    @Value("${hihi}")
    String value;

//    @Value("${hihi.test}")
//    String value2;

    @Test
    public void sepl(){
        System.out.println(value);
//        System.out.println(value2);
    }



}
