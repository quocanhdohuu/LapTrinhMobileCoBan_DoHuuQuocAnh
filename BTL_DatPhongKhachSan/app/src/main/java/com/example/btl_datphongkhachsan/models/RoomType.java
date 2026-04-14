package com.example.btl_datphongkhachsan.models;

import java.io.Serializable;

public class RoomType implements Serializable {
    private int RoomTypeID;
    private String Name;
    private String Description;
    private int Capacity;
    private double DefaultPrice;
    private int TotalRooms;
    private int ReservedRooms;
    private int OccupiedRooms;
    private int AvailableRooms;

    public int getRoomTypeID() { return RoomTypeID; }
    public String getName() { return Name; }
    public String getDescription() { return Description; }
    public int getCapacity() { return Capacity; }
    public double getDefaultPrice() { return DefaultPrice; }
    public int getTotalRooms() { return TotalRooms; }
    public int getAvailableRooms() { return AvailableRooms; }
}