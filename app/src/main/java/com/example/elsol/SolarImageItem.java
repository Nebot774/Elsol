package com.example.elsol;

public class SolarImageItem {
    private String title; // Título de la imagen solar
    private int imageUrl; // URL o referencia a la imagen solar

    // Constructor
    public SolarImageItem(String title, int imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}

