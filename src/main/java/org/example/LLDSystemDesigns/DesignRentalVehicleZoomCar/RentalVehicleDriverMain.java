package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.Vehicle;
import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class RentalVehicleDriverMain {
    public static void main(String[] args){
        List<User> users = getUserList();
        List<Vehicle> vehicles = getVehiclesList();
        List<Store> stores = getStoreList();

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(stores,users);

        User user = users.get(0);
        Location location = new Location(110093, "East Delhi", "Delhi", "India");
        List<Store> stores1 = vehicleRentalSystem.getStoreByLocation(location);
        Store chooseStore = stores1.get(0);

        List<Vehicle> vehicleList = chooseStore.getAllVehicles(VehicleType.CAR);


        VehicleReservation reservation = chooseStore.createReservation(vehicleList.get(0),user);

        Bill bill = new Bill(reservation);
        Payment payment = new Payment();
        payment.payBill(bill);

        chooseStore.completeReservation(reservation.reservationId);

    }

    private static List<Store> getStoreList() {
        List<Store> stores = new ArrayList<>();
        return stores;
    }

    private static List<Vehicle> getVehiclesList() {
        List<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }

    private static List<User> getUserList() {
         List<User>   users = new ArrayList<>();
         return users;
    }
}
