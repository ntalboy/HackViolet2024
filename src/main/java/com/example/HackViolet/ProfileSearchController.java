package com.example.HackViolet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileSearchController {
    @GetMapping("/search")
    public String search(@RequestParam(value = "username", defaultValue = "EMPTY") String username) {
        if (username.equals("EMPTY")) {
            return "ERROR";
        }
        return "TODO";
    }
}
