package com.example.HackViolet.scrapers;
import masecla.reddit4j.client.Reddit4J;
import masecla.reddit4j.client.UserAgentBuilder;

public class RedditScraper implements Scraper{
    @Override
    public String getProfileDescription() {
        Reddit4J client = Reddit4J.rateLimited().setUsername("HackViolet24winners").setPassword("WillUbben")
                .setClientId("App ID").setClientSecret("Secret")
                .setUserAgent(new UserAgentBuilder().appname("App Name").author("Your Name").version("1.0"));
        client.connect();

        return "description";
    }
}
