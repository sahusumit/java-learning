package org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar;

import org.example.LLDSystemDesigns.DesignRentalVehicleZoomCar.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<User> users = new ArrayList<>();
    List<Store> stores = new ArrayList<>();

    VehicleRentalSystem(List<Store> stores, List<User> users){
        this.stores = stores;
        this.users = users;
    }

    public List<Store> getStoreByLocation(Location location){
        return stores.stream().filter((store -> (store.storeLocation.city.equals(location.city)))).toList();
    }


    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void addStore(Store store){
        stores.add(store);
    }

    public void removeStore(Store store){
        stores.remove(store);
    }




}
