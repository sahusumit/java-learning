package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.List;

public class Building {
    List<Floor> floors;
    Building(List<Floor> floors){
        this.floors = floors;
    }

    public void  addFloor(Floor floor){
        floors.add(floor);
    }
    public void  removeFloor(Floor floor){
        floors.remove(floor);
    }

    public List<Floor>  getAllFloors(){
        return floors;
    }
}
