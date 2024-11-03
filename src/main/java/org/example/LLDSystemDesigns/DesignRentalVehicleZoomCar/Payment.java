package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

public class Payment {
    int paymentId;
    Bill bill;
    String paymentStatus;

    public void payBill(Bill bill){
        this.bill = bill;
        this.paymentId = Integer.parseInt(String.valueOf(Math.random()));
        this.paymentStatus = "Complete";
    }
}
