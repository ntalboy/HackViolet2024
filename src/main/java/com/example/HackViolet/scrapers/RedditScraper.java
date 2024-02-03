package com.example.HackViolet.scrapers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;
import java.util.ArrayList;

//import masecla.reddit4j.client.Reddit4J;
//import masecla.reddit4j.client.UserAgentBuilder;
//import masecla.reddit4j.exceptions.AuthenticationException;
//import masecla.reddit4j.objects.RedditPost;
//import masecla.reddit4j.objects.Sorting;



public class RedditScraper implements Scraper{

    private String username;

    public RedditScraper(String username) {
        this.username = username;
    }

    @Override
    public String getProfileDescription() {

        StringBuilder result = new StringBuilder();

        try {
            String url = "https://www.reddit.com/user/" + username + "/comments.json";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(response.toString());

                if (rootNode.has("data") && rootNode.get("data").has("children")) {
                    for (JsonNode childNode : rootNode.get("data").get("children")) {
                        if (childNode.has("data") && childNode.get("data").has("body")) {
                            String bodyText = childNode.get("data").get("body").asText();
                            result.append(bodyText).append("\n");
                        }
                    }
                }
            } else {
                System.out.println("Failed to fetch user comments. HTTP response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }
}




//Depreciated
        /*
        UserAgentBuilder userAgent = new UserAgentBuilder().appname("HackViolet2024").author("HackViolet24winners").version("2.0");
        Reddit4J client = Reddit4J.rateLimited().setClientId("43aBBYBHYwcuvk-10lfPKQ").setClientSecret("xp_2NxKe0wwKGCETEir6TShUjh31AA").setUserAgent(userAgent);

        try {
            client.userlessConnect();;
        } catch (IOException | AuthenticationException | InterruptedException e) {
            System.out.println("Connection Error");
        }

        List<RedditPost> currentPosts;
        List<String> currentTitles = new ArrayList<>();

        String titles = "";

        try {
            currentPosts = client.getSubredditPosts("WarriorGamer", Sorting.NEW).submit();
            //sets current titles. i-- because it needs to be placed in backwards
            for (int i = currentPosts.size() - 1; i >= 0; i--){
                //currentTitles.add(currentPosts.get(i).getTitle());
                titles = titles + "\n" + currentPosts.get(i).getTitle();
            }

        }catch (AuthenticationException | IOException | InterruptedException e){
            System.out.println("Initial Post Grab ERROR: " + e);
        }

        return titles;*/
