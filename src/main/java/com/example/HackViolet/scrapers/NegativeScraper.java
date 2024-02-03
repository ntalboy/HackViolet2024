package com.example.HackViolet.scrapers;

/**
 * Sample scraper that always gives negative flag
 */
public class NegativeScraper implements Scraper {
    /**
     * Description where flag was not found
     *
     * @return message that shouldn't be flagged by language model
     */
    @Override
    public String getProfileDescription() {
        return "This is a good message with no bad indicators!";
    }
}
