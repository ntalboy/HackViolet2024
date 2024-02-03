package com.example.HackViolet;

import com.example.HackViolet.model.OnlineProfiles;
import com.example.HackViolet.scrapers.RedditScraper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileSearchController {
    @GetMapping("/search")
    public OnlineProfiles search(@RequestParam(value = "username", defaultValue = "EMPTY") String username) {
        String redditFlag = LanguageChecker.reviewProfile(new RedditScraper(username));
        OnlineProfiles onlineProfiles = new OnlineProfiles(
                redditFlag,
                "0",
                "0",
                "0");

        if (username.equals("EMPTY")) {
            return null;
        }

        return onlineProfiles;
    }
}
