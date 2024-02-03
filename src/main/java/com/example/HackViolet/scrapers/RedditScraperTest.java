package com.example.HackViolet.scrapers;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class RedditScraperTest {

    @Test
    public void testRedditScraper() {
        RedditScraper redditScraper = new RedditScraper("Majestic_Fox_428");
        String result = redditScraper.getProfileDescription();

        System.out.println(result);
        assertNotNull(result);
        assertTrue(result.length() > 0);

    }
}