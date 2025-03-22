package com.example.chatbot_mobile_java.bin.data;

public class Api {
    private int id;
    private String name;
    private String description;
    private String imageURL;
    private String shortName;

    public Api(int id, String name, String description, String imageURL, String shortName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "apiList{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", description='" + this.description + '\'' +
                ", imageURL='" + this.imageURL + '\'' +
                '}';
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
