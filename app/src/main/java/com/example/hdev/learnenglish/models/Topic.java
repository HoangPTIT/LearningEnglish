package com.example.hdev.learnenglish.models;

public class Topic {

    private String mPicture;

    private String mTopic;

    private int mStatus;

    public Topic(final String picture, final String topic, final int status) {
        mPicture = picture;
        mTopic = topic;
        mStatus = status;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setPicture(final String picture) {
        mPicture = picture;
    }

    public String getTopic() {
        return mTopic;
    }

    public void setTopic(final String topic) {
        mTopic = topic;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(final int status) {
        mStatus = status;
    }
}
