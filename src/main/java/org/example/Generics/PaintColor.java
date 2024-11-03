package org.example.Generics;

import java.util.List;

public class PaintColor {
    public  void setColor(List<Vehicle> vehicleList){
    }
    public  void setColorUsingUBWildCard(List<? extends Vehicle> vehicleList){
    }

    /**
     * this is work on only Vehicle class and obove the Vehicle class or its parent class;
     * @param vehicleList
     */
    public  void setColorUsingLBWildCard(List<? super Vehicle> vehicleList){
    }
}
