package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.List;

public class ExternalDispatcher {
    List<ElevatorController> controllers = ElevatorCreator.elevatorControllers;

    public void submitExternalRequest(int floor, Direction direction){
        for(ElevatorController elevatorController: controllers){
            int elevatorId = elevatorController.elevatorCar.elevatorId;
            if(elevatorId%2==1 && floor%2==1 ){
                elevatorController.submitExternalRequest(floor, direction);
            } else if (elevatorId%2==0&& floor%2==0 ) {
                elevatorController.submitExternalRequest(floor, direction);
            }
        }

    }

}
