package org.pirat9600q.controllers;

import org.pirat9600q.entities.User;
import org.pirat9600q.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class Main {

    UserRepository userRepository;

    @Autowired
    public Main(UserRepository ur) {
        userRepository = ur;
    }

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

    @RequestMapping(value = "register", method = RequestMethod.GET)
    String registerForm(@ModelAttribute("user")User user) {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    String register(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "register";
        }
        else {
            userRepository.save(user);
            return "redirect:/register-success";
        }
    }

    @RequestMapping(value = "register-success", method = RequestMethod.GET)
    void registerSuccess() {}

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
