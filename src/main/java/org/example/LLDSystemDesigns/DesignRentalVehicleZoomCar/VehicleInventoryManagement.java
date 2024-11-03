package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.Vehicle;
import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {
    int inventoryId;
    List<Vehicle> vehicles = new ArrayList<>();

    VehicleInventoryManagement(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return  this.vehicles;
    }

    public List<Vehicle> getVehiclesByType(VehicleType type){
        return  vehicles.stream().
                filter(vehicle->(vehicle.getType().equals(type)))
                .toList();
    }


    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
}
