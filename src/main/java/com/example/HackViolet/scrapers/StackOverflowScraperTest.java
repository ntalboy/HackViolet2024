package com.example.HackViolet.scrapers;

import org.testng.annotations.Test;

public class StackOverflowScraperTest {
    @Test
    public void testStackOverflowScraper() {
        StackOverflowScraper sos = new StackOverflowScraper("maraca");
        sos.getProfileDescription();

        VenmoScraper vs = new VenmoScraper();
        vs.getProfileDescription();
    }
}
