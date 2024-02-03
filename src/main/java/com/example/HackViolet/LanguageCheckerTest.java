package com.example.HackViolet;

import com.example.HackViolet.scrapers.NegativeScraper;
import com.example.HackViolet.scrapers.PositiveScraper;
import com.example.HackViolet.scrapers.Scraper;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class LanguageCheckerTest {
    @Test
    public void testLanguageChecker() {
        Scraper ps = new PositiveScraper();
        Scraper ns = new NegativeScraper();

        String responsePositive = LanguageChecker.reviewProfile(ps);
        String responseNegative = LanguageChecker.reviewProfile(ns);
        System.out.println(responsePositive);
        System.out.println(responseNegative);
        assertTrue(responsePositive.length() > 1);
        assertEquals(responseNegative, "0");
    }
}
