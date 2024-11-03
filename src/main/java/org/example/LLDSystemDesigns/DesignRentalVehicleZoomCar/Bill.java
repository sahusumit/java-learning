package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

public class Bill {
    VehicleReservation vehicleReservation;
    String billPaid;
    double amount;
    boolean isBillPaid;

    Bill(VehicleReservation reservation){
        this.vehicleReservation = reservation;
        this.amount = computeBillAmount();
        isBillPaid = false;
    }

    private double computeBillAmount() {
        return  100.0;
    }
}
