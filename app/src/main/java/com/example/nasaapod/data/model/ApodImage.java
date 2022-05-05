package com.example.nasaapod.data.model;

/**
 * TODO: Fill model with variables like in PlaceholderItem.java returned by https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
 *
 */

public class ApodImage {

    public String date;
    public String explanation;
    public String title;
    public String hdurl;

    public ApodImage(String date, String explanation, String title, String hdurl) {
        this.date = date;
        this.explanation = explanation;
        this.title = title;
        this.hdurl = hdurl;
    }
}
