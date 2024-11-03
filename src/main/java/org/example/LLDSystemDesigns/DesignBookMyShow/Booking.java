package org.example.LLDSystemDesigns.DesignBookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    int id;
    Show show;
    List<Seat> bookingSeat = new ArrayList<>();
    Payment payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookingSeat() {
        return bookingSeat;
    }

    public void setBookingSeat(List<Seat> bookingSeat) {
        this.bookingSeat = bookingSeat;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
