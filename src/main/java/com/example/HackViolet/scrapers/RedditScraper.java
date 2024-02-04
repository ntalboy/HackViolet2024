package com.example.HackViolet.scrapers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RedditScraper implements Scraper {

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
//            connection.setRequestProperty("User-Agent", "hackviolet/1.0 (by /u/leather_chestplate)");
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

                JsonElement jsonElement = JsonParser.parseString(response.toString());

                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("data") && jsonObject.getAsJsonObject("data").has("children")) {
                        JsonArray childrenArray = jsonObject.getAsJsonObject("data").getAsJsonArray("children");
                        for (JsonElement childElement : childrenArray) {
                            if (childElement.isJsonObject() && childElement.getAsJsonObject().has("data")
                                    && childElement.getAsJsonObject().getAsJsonObject("data").has("body")) {
                                String bodyText = childElement.getAsJsonObject().getAsJsonObject("data").get("body").getAsString();
                                result.append(bodyText).append("\n");
                            }
                        }
                    }
                }
            } else {
                System.out.println("Reddit Scraper failed to fetch user comments. HTTP response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }
}
