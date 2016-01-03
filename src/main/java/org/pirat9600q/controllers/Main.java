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
    String login(@Valid @ModelAttribute("login") LoginForm form) {
        return "login";
    }

    @RequestMapping(value = "loggedIn", method = RequestMethod.GET)
    String loggedIn(Model model) {
        model.addAttribute("status", "authenticated");
        return "loggedIn";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    String logoutForm() {
        return "logout";
    }

    @RequestMapping(value = "protected", method = RequestMethod.GET)
    String protectedPage() {
        return "protected";
    }

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
