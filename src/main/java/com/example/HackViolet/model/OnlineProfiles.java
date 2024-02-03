package com.example.HackViolet.model;

public class OnlineProfiles {
    private String redditFlag;
    private String twitterFlag;
    private String linkedinFlag;
    private String facebookFlag;

    public OnlineProfiles(String redditFlag, String twitterFlag, String linkedinFlag, String facebookFlag) {
        this.redditFlag = redditFlag;
        this.twitterFlag = twitterFlag;
        this.linkedinFlag = linkedinFlag;
        this.facebookFlag = facebookFlag;
    }

    public String getRedditFlag() {
        return redditFlag;
    }

    public String getTwitterFlag() {
        return twitterFlag;
    }

    public String getFacebookFlag() {
        return facebookFlag;
    }

    public String getLinkedinFlag() {
        return linkedinFlag;
    }

    public void setRedditFlag(String redditFlag) {
        this.redditFlag = redditFlag;
    }

    public void setTwitterFlag(String twitterFlag) {
        this.twitterFlag = twitterFlag;
    }

    public void setFacebookFlag(String facebookFlag) {
        this.facebookFlag = facebookFlag;
    }

    public void setLinkedinFlag(String linkedinFlag) {
        this.linkedinFlag = linkedinFlag;
    }

    @Override
    public String toString() {
        return "OnlineProfiles{" +
                "redditFlag='" + this.redditFlag + '\'' +
                ", twitterFlag='" + this.twitterFlag + '\'' +
                '}';
    }
}
