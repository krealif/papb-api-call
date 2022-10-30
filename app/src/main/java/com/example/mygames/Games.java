package com.example.mygames;

import com.google.gson.annotations.SerializedName;

public class Games {
    @SerializedName("title")
    private String title;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("genre")
    private String genre;
    @SerializedName("developer")
    private String developer;

    public Games(String title, String thumbnail, String genre, String developer, String platform) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.genre = genre;
        this.developer = developer;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getGenre() {
        return genre;
    }

    public String getDeveloper() {
        return developer;
    }
}
