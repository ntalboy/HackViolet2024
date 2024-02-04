package com.example.HackViolet;

import com.example.HackViolet.scrapers.Scraper;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.*;

public class LanguageChecker {
    /**
     * Reviews description found in social media profile
     *
     * @param scraper Social media scraper that retrieves profile
     * @return true string if flag was found, false otherwise
     */
    public static String reviewProfile(Scraper scraper) {
        final String promptInstructions = "Review the following social media profile description " +
                "for discriminatory language. If you find a red flag, make your response the sentence that was the red flag" +
                ", otherwise respond with 0. Do NOT respond with any additional text. \n DESCRIPTION:";
        String description = scraper.getProfileDescription();

        String prompt = promptInstructions + description;
        List<ChatMessage> messages = new ArrayList<>();
        OpenAiService service = new OpenAiService("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");
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), prompt);
        messages.add(userMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo-0125")
                .messages(messages)
                .maxTokens(800)
                .build();
        ChatMessage responseMessage = service.createChatCompletion(chatCompletionRequest).getChoices().get(0).getMessage();

        return responseMessage.getContent();
    }
}
