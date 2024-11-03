package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

public class Location {
    int locationId;
    String Address;
    String city;
    String state;
    String country;
    int pinCode;

    public Location(int pinCode, String city, String state, String country){
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;

    }
}
