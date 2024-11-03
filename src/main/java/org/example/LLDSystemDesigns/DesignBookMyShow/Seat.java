package org.example.LLDSystemDesigns.DesignBookMyShow;

import org.example.LLDSystemDesigns.DesignBookMyShow.Enums.SeatCategory;

public class Seat {
    int seatId;
    int price;
    String row;
    SeatCategory seatCategory;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
