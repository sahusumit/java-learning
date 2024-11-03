package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.List;

public class InternalDispatcher {
    List<ElevatorController> controllers = ElevatorCreator.elevatorControllers;

    public void submitInternalRequest(int floor, ElevatorCar elevatorCar){
        for(ElevatorController controller: controllers){
            if(controller.elevatorCar.elevatorId == elevatorCar.elevatorId){

            }
        }
    }
}
