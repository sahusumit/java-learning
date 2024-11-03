package org.example.Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        List <Vehicle> vehicleList = new ArrayList<>();
        List<Bus> busList = new ArrayList<>();

        Vehicle vehicleObj = new Vehicle();
        Bus busObj = new Bus();
       // vehicleObj = busObj; // valid
        //

        // vehicleList = busList// Is this  valid case: No
        //beacuse in the list of vehicale i can make the object of Bus and car both as below
        vehicleList.add(new Bus());
        vehicleList.add(new Car());

        PaintColor paintColor = new PaintColor();
        paintColor.setColor(vehicleList);
       // paintColor.setColor(busList);// this can't be done, it expect the parent class


        /**
         * This can be handle by the upper bound wildCard method <? extends upperboundClassName>
         *   means it accept both it parent and child class; like below
         */

        paintColor.setColorUsingUBWildCard(busList);

       // paintColor.setColorUsingLBWildCard(busList);// not work
        paintColor.setColorUsingLBWildCard(vehicleList); //it works on its given class and above class;

        List<Object> objectsList = new ArrayList<>();
        paintColor.setColorUsingLBWildCard(objectsList); // this is acceptable because object is the parent class of the vehicle class;






    }
}
