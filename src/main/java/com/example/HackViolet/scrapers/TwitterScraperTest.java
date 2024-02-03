package com.example.HackViolet.scrapers;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

public class TwitterScraperTest {

    @Test
    public void testTwitterScraper() {
        TwitterScraper TwitterScraper = new TwitterScraper("TheDunkCentral");
        String result = TwitterScraper.getProfileDescription();

        System.out.println(result);
        assertNotNull(result);
        assertTrue(result.length() > 0);

    }
}