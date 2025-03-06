 package com.example.backend.cotroller;

import com.example.backend.model.User;
import com.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    
    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully.");
    }
    

        @GetMapping("/login")
        public String loginForm() {
            return "login"; // Thymeleaf template for login page
        }

        @PostMapping("/login")
        public String loginSubmit(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
            User user = userService.findByUsername(username);
            if (user != null && passwordEncoder.matches(password, user.getPassword())) {  // Secure password check
                // Login successful
                return "redirect:/posts";
            } else {
                model.addAttribute("error", "Invalid Credentials");
                return "login";
            }
        }

    
        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUser(@PathVariable Long id) {
            return (ResponseEntity<User>) ResponseEntity.of(userService.getUserById(id));
        }


        @DeleteMapping("/users/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

}