package com.example.btl_datphongkhachsan.models;

import java.io.Serializable;

public class Reservation implements Serializable {
    private int StayID;
    private int ReservationID;
    private String Status;
    private String CheckIn;
    private String CheckOut;
    private String RoomType;
    private int Quantity;
    private double TotalAmount;

    public int getStayID() { return StayID; }
    public int getReservationID() { return ReservationID; }
    public String getStatus() { return Status; }
    public String getCheckIn() { return CheckIn; }
    public String getCheckOut() { return CheckOut; }
    public String getRoomType() { return RoomType; }
    public int getQuantity() { return Quantity; }
    public double getTotalAmount() { return TotalAmount; }
}