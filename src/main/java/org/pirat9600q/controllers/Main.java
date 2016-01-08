package org.pirat9600q.controllers;

import org.hibernate.validator.constraints.NotBlank;
import org.pirat9600q.entities.User;
import org.pirat9600q.repositories.UserRepository;
import org.pirat9600q.validations.annotations.PasswordsMatch;
import org.pirat9600q.validations.contracts.PasswordConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Controller
@RequestMapping("/")
public class Main {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Main(UserRepository ur, PasswordEncoder pe) {
        userRepository = ur;
        passwordEncoder = pe;
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
    String registerForm(@ModelAttribute("user")RegisterForm user) {
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    String register(@Valid @ModelAttribute("user")RegisterForm form, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "register";
        }
        else {
            userRepository.save(registerFormToUser(form));
            return "redirect:/register-success";
        }
    }

    @RequestMapping(value = "register-success", method = RequestMethod.GET)
    void registerSuccess() {}

    private User registerFormToUser(RegisterForm form) {
        final User user = new User();
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        return user;
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

    @PasswordsMatch
    public static class RegisterForm implements PasswordConfirmation {

        private String email;

        private String username;

        private String password;

        private String confirmPassword;

        @NotBlank
        @Size(min = 4, max = 50)
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @NotBlank
        @Size(min = 4, max = 50)
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @NotBlank
        @Size(min = 4, max = 20)
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @NotBlank
        @Size(min = 4, max = 20)
        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
        }
    }
}
