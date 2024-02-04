package com.example.HackViolet.scrapers;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class StackOverflowScraper implements Scraper {
    private String username;
    public StackOverflowScraper(String username) {
        this.username = username;
    }
    @Override
    public String getProfileDescription() {
        String uri = String.format("https://api.stackexchange.com/2.3/users/%s/answers?order=desc&sort=activity&site=stackoverflow",
                URLEncoder.encode(username, StandardCharsets.UTF_8));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "application/json")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
