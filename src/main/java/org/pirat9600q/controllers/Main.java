package org.pirat9600q.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @RequestMapping("/")
    String index() {
        return "index";
    }
}
