package com.example.HackViolet.scrapers;

/**
 * Sample scraper that always gives positive flag
 */
public class PositiveScraper implements Scraper {
    /**
     * Description where flag was found
     *
     * @return message that should be flagged by language model
     */
    @Override
    public String getProfileDescription() {
        return "I hate women! I love cars!";
    }
}
