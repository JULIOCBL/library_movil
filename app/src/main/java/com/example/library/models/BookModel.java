package com.example.library.models;


import com.google.gson.annotations.SerializedName;

public class BookModel {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("year")
    private int year;

    // Constructor
    public BookModel(int id, String title,  String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters y Setters
    public BookModel getId() {
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
