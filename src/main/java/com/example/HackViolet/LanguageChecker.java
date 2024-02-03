package com.example.HackViolet;

import com.example.HackViolet.scrapers.Scraper;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class LanguageChecker {
    /**
     * Reviews description found in social media profile
     *
     * @param scraper Social media scraper that retrieves profile
     * @return yes string if flag was found, no otherwise
     */
    public static boolean reviewProfile(Scraper scraper) {
        final String promptInstructions = "Review the following social media profile description " +
                "for discriminatory language. If it contains any red flags respond with yes, " +
                "otherwise no. Make sure that your response is a single lowercase word with no punctuation.\n";
        String description = scraper.getProfileDescription();

        String prompt = promptInstructions + description;

        OpenAiService service = new OpenAiService("your_token");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("babbage-002")
                .echo(true)
                .build();

        String response = service.createCompletion(completionRequest).getChoices().get(0).getText();
        return response.equals("yes");
    }
}
