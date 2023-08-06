package com.sleeklycoding;

public class App {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel("SleeklyCoding");
        User user1 = new User("Michael Smith");
        User user2 = new User("Emily Johnson");

        channel.registerObserver(user1);
        channel.registerObserver(user2);

        channel.uploadVideo("The Factory Design Pattern");
    }
}