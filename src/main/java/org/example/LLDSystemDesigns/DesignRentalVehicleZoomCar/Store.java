package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;


import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.Vehicle;
import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int id;
    Location storeLocation;
    VehicleInventoryManagement vehicleInventory;
     List<VehicleReservation> reservations = new ArrayList<>();


   public List<Vehicle> getAllVehicles(VehicleType type){
       return  vehicleInventory.getVehiclesByType(type);
   }

   public VehicleReservation createReservation(Vehicle vehicle, User user){
       VehicleReservation  vehicleReservation = new VehicleReservation();
       vehicleReservation.createReservation(user, vehicle);
       reservations.add(vehicleReservation);
       return vehicleReservation;
   }

   public boolean completeReservation(int reservationId){
       return true;
   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(Location storeLocation) {
        this.storeLocation = storeLocation;
    }

    public VehicleInventoryManagement getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(VehicleInventoryManagement vehicleInventory) {
        this.vehicleInventory = vehicleInventory;
    }

    public List<VehicleReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<VehicleReservation> reservations) {
        this.reservations = reservations;
    }
}
