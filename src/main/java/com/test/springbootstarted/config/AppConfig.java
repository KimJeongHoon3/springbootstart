package com.test.springbootstarted.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AppConfig {

    @Bean
    public TestConfig getTestConfig(){
        TestConfig testConfig=new TestConfig();
        System.out.println(testConfig.hashCode());
        return testConfig;
    }

    @Bean
    public Test2Config getTest2Config(TestConfig testConfig){
        System.out.println(testConfig.hashCode());
        return new Test2Config();
    }

}
