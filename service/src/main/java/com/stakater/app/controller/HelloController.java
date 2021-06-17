package com.stakater.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class HelloController {

    @Value("${app.greet.name}")
    private String name;

    @GetMapping
    public String greet() {
        return "Hello " + name;
    }
}
