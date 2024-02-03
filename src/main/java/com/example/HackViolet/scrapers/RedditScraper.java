package com.example.HackViolet.scrapers;

import masecla.reddit4j.client.Reddit4J;
import masecla.reddit4j.client.UserAgentBuilder;
import masecla.reddit4j.exceptions.AuthenticationException;
import masecla.reddit4j.objects.RedditPost;
import masecla.reddit4j.objects.Sorting;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RedditScraper implements Scraper{
    @Override
    public String getProfileDescription() {

        UserAgentBuilder userAgent = new UserAgentBuilder().appname("HackViolet2024").author("HackViolet24winners").version("2.0");
        Reddit4J client = Reddit4J.rateLimited().setClientId("43aBBYBHYwcuvk-10lfPKQ").setClientSecret("xp_2NxKe0wwKGCETEir6TShUjh31AA").setUserAgent(userAgent);

        try {
            client.userlessConnect();;
        } catch (IOException | AuthenticationException | InterruptedException e) {
            System.out.println("Connection Error");
        }

        List<RedditPost> currentPosts;
        List<String> currentTitles = new ArrayList<>();

        String titles = "";

        try {
            currentPosts = client.getSubredditPosts("WarriorGamer", Sorting.NEW).submit();
            //sets current titles. i-- because it needs to be placed in backwards
            for (int i = currentPosts.size() - 1; i >= 0; i--){
                //currentTitles.add(currentPosts.get(i).getTitle());
                titles = titles + "\n" + currentPosts.get(i).getTitle();
            }

        }catch (AuthenticationException | IOException | InterruptedException e){
            System.out.println("Initial Post Grab ERROR: " + e);
        }

        return titles;
    }
}
