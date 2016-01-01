package org.pirat9600q.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @RequestMapping("/")
    String home() {
        return "Hello world!";
    }
}
