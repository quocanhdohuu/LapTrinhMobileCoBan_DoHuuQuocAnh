package com.example.btl_mobile;

public class Booking {
    private String roomName;
    private String dateRange;
    private String status;

    public Booking(String roomName, String dateRange, String status) {
        this.roomName = roomName;
        this.dateRange = dateRange;
        this.status = status;
    }

    public String getRoomName() { return roomName; }
    public String getDateRange() { return dateRange; }
    public String getStatus() { return status; }
}
