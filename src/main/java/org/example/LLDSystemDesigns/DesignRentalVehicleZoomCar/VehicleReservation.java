package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.Vehicle;

import java.util.Date;

public class VehicleReservation {
    int reservationId;
    Vehicle vehicle;
    User user;
    ReservationStatus reservationStatus;
    Date bookingDate;
    Date  bookingFrom;
    Date dateBookTo;
    String bookingTill;
    Location pickUpLocation;
    Location dropLocation;
    Location location;
    ReservationType reservationType;


    public int createReservation(User user, Vehicle vehicle){
        reservationId = Integer.parseInt(String.valueOf(Math.random()));
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        return  reservationId;
    }


    //CRUD operation
}
