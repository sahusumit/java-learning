package org.example.LLDSystemDesigns.DesignElevatorSystem;

public class ElevatorDisplay {
    Direction direction;
    ElevatorState state;
    int floor;

    public void setDisplay(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
    }
    public void showDisplay(ElevatorState state){
        if(state == ElevatorState.IDLE) {
            System.out.println("<font color=\"#3d9900\">" + direction + "  " + floor + " % </font>");
        }else{
           System.out.println("<font color=\"#e64343\">" + direction + "  " + floor + " % </font>");
        }
    }
}
