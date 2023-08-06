package com.sleeklycoding;

public class YouTubeChannel extends Subject {
    private String channelName;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("Uploading video: '" + videoTitle + "' on " + channelName + ".");
        notifyObservers(videoTitle);
    }
}
