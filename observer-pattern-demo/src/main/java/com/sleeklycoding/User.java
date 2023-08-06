package com.sleeklycoding;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Hello " + name + ", a new video titled '" + videoTitle + "' has been uploaded!");
    }
}
