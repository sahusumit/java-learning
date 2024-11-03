package org.example.LLDSystemDesigns.DesignElevatorSystem;

import java.util.PriorityQueue;

public class ElevatorController {
    ElevatorCar elevatorCar;
    //Algorithm to control the elevator
    PriorityQueue<Integer>  upMiniQueue;
    PriorityQueue<Integer> downMaxQueue;

    ElevatorController(ElevatorCar elevatorCar){
        this.elevatorCar = elevatorCar;
        upMiniQueue = new PriorityQueue<>();
        downMaxQueue = new PriorityQueue<>((a, b) -> b-a);
    }

    public void submitExternalRequest(int floor, Direction direction){
        if(direction == Direction.DOWN){
            downMaxQueue.offer(floor);
        }else{
            upMiniQueue.offer(floor);
        }

    }
    public void submitInternalRequest(){
    }

    public void controlElevator(){
        while (true){
            if(elevatorCar.elevatorDirection == Direction.UP){

            }
        }
    }
}
