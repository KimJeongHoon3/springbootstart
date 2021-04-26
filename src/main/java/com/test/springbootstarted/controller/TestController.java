package com.test.springbootstarted.controller;

import com.test.springbootstarted.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/hello")
    public String getHello(){
        return "hello "+testService.getName();
    }
}
