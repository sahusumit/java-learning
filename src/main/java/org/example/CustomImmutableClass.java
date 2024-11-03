package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Declare class as final so that no other class extended or inherited it.
 */
public final class CustomImmutableClass {
    private final String name;
    private final List<Object> petNameList;
    CustomImmutableClass(String name, List<Object> petNameList){
        this.name= name;
        this.petNameList = petNameList;
    }

    public String getName(){
        return name;
    }
    public List<Object> getPetNameList(){
        return new ArrayList<>(petNameList);
    }
}
