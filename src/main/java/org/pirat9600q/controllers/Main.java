package org.pirat9600q.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @Value("${home.welcome}")
    private String welcome;

    @RequestMapping("/")
    String home() {
        return welcome;
    }
}
