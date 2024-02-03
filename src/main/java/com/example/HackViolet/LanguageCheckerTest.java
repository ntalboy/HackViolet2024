package com.example.HackViolet;

import com.example.HackViolet.scrapers.NegativeScraper;
import com.example.HackViolet.scrapers.PositiveScraper;
import com.example.HackViolet.scrapers.Scraper;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LanguageCheckerTest {
    @Test
    public void testLanguageChecker() {
        Scraper ps = new PositiveScraper();
        Scraper ns = new NegativeScraper();

        boolean responsePositive = LanguageChecker.reviewProfile(ps);
        boolean responseNegative = LanguageChecker.reviewProfile(ns);

        assertTrue(responsePositive);
        assertFalse(responseNegative);
    }
}
