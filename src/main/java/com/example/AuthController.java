package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth") // This opens the "/auth" door
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody MovieUser user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "User already exists!";
        }
        userRepository.save(user);
        return "Success";
    }

    @PostMapping("/login") // This opens the "/login" door
    public String login(@RequestBody MovieUser user) {
        return userRepository.findByUsername(user.getUsername())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .map(u -> "Success")
                .orElse("Invalid Credentials");
    }
}
