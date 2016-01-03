package org.pirat9600q.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class Main {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    void login(@Valid @ModelAttribute("login") LoginForm form) {}

    @RequestMapping(value = "loggedIn", method = RequestMethod.GET)
    void loggedIn(Model model) {
        model.addAttribute("status", "authenticated");
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    void logoutForm() {}

    @RequestMapping(value = "protected", method = RequestMethod.GET)
    void protectedPage() {}

    public static class LoginForm {

        private String username;

        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
