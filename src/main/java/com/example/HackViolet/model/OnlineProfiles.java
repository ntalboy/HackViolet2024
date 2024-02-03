package com.example.HackViolet.model;

public class OnlineProfiles {
    private String redditFlag;
    private String twitterFlag;

    public OnlineProfiles(String redditFlag, String twitterFlag) {
        this.redditFlag = redditFlag;
        this.twitterFlag = twitterFlag;
    }

    public String getRedditFlag() {
        return redditFlag;
    }

    public String getTwitterFlag() {
        return twitterFlag;
    }

    public void setRedditFlag(String redditFlag) {
        this.redditFlag = redditFlag;
    }

    public void setTwitterFlag(String twitterFlag) {
        this.twitterFlag = twitterFlag;
    }

    @Override
    public String toString() {
        return "OnlineProfiles{" +
                "redditFlag='" + this.redditFlag + '\'' +
                ", twitterFlag='" + this.twitterFlag + '\'' +
                '}';
    }
}
