package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.List;

public class InternalButton {
    InternalDispatcher internalDispatcher = new InternalDispatcher();
    Direction direction;
    int[] floorNumbers = {1,2,3,4,5,6,7,8,9,10};

    public void pressButton(int floorNumber, ElevatorCar elevatorCar){
        internalDispatcher.submitInternalRequest(floorNumber, elevatorCar);
    }

}
