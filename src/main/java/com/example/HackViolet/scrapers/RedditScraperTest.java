package com.example.HackViolet.scrapers;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class RedditScraperTest {

    @Test
    public void testRedditScraper() {
        RedditScraper redditScraper = new RedditScraper("HackViolet24winners");
        String result = redditScraper.getProfileDescription();

        System.out.println(result);
        assertNotNull(result);
        assertTrue(result.length() > 0);

    }
}