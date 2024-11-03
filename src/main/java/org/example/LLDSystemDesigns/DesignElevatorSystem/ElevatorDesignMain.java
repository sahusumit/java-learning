package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorDesignMain {
    public static void main(String[] args){
        List<Floor> floors = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);
        Floor floor6 = new Floor(6);
        floors.add(floor1);
        floors.add(floor2);
        floors.add(floor3);
        floors.add(floor4);
        floors.add(floor5);
        floors.add(floor6);

        Building building = new Building(floors);


    }
}
