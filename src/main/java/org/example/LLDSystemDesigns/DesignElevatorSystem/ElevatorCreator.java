package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    public static List<ElevatorController> elevatorControllers = new ArrayList<>();
    static {
        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.elevatorId = 1;
        ElevatorController elevatorController1 = new ElevatorController(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.elevatorId = 2;
        ElevatorController elevatorController2 = new ElevatorController(elevatorCar2);

        elevatorControllers.add(elevatorController1);
        elevatorControllers.add(elevatorController2);
    }
}
