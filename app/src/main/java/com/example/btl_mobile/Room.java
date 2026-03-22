package com.example.btl_mobile;

public class Room {
    private String name;
    private String price;
    private float rating;

    public Room(String name, String price, float rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
    public float getRating() { return rating; }
}
