package com.example.HackViolet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileSearchController {
    @GetMapping("/digging")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
