package com.example.HackViolet.scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TwitterScraper implements Scraper{

    private String username;
    //private String API_key = "4qi6Zlt4ZbtArnMAXhtOa4AXI";
    //private String API_key_secret = "BmmwKzVn7C9kKyWHM48OpxtIRHSxMDFGk389NmwvPS5VNwlXMU";
    //private String bearer_token = "AAAAAAAAAAAAAAAAAAAAAFjisAEAAAAAbiIudssoGvcpF9g%2FD8IER6P7EVc%3DujPUd6i7N7eWzaU0LpomhFi3jhTqURiVTFlmq81pCM96R2maYS";

    public TwitterScraper(String username) {
        this.username = username;
    }

    @Override
    public String getProfileDescription() {

        String url = "https://twitter.com/" + username;

        try {
            Document document = Jsoup.connect(url).get();
            Elements tweets = document.select("div[data-testid='tweet']");

            StringBuilder result = new StringBuilder();

            for (Element tweet : tweets) {
                String tweetText = tweet.select("div[data-testid='tweetText']").text();
                System.out.println(tweetText + "\n\n");
                result.append(tweetText).append("\n");
            }

            return result.toString();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return "";

    }
}
