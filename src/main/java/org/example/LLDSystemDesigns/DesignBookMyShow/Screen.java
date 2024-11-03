package org.example.LLDSystemDesigns.DesignBookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int screenId;
    int size;
    List<Seat> seats = new ArrayList<>();

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
