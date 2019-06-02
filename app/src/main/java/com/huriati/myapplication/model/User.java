package com.huriati.myapplication.model;

public class User {
    private String Id;
    private String username;
    private String imageUrl;

    public User() {
    }

    public User(String Id, String username, String imageUrl) {
        this.Id = Id;
        this.username = username;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
