package com.example.HackViolet.scrapers;

import org.testng.annotations.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class RedditScraperTest {

    @Test
    public void testRedditScraper() {
        RedditScraper redditScraper = new RedditScraper();
        String result = redditScraper.getProfileDescription();

        assertNotNull(result);
        assertTrue(result.length() > 0);

    }
}