package org.example.LLDSystemDesigns.DesignElevatorSystem;

public class ElevatorCar {
    int elevatorId;
    ElevatorDisplay display;
    Direction elevatorDirection;
    InternalButton internalButton;
    ElevatorDoor elevatorDoor;
    ElevatorState elevatorState;
    int currentFloor;

    public ElevatorCar(){
        display = new ElevatorDisplay();
        internalButton = new InternalButton();
        elevatorState = ElevatorState.IDLE;
        elevatorDirection = Direction.UP;
        currentFloor = 0;
        elevatorDoor = new ElevatorDoor();
    }

    public void showDisplay(){
        display.showDisplay(elevatorState);
    }
}
