package org.example.JavaCollections.collectionClasses;

import java.util.Comparator;

public class PersonResources implements Comparator<PersonResources> {
    public   String firstName;
    public String lastName;
    private String city;
    private int age;

    public  PersonResources(){

    }

    public PersonResources(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Compare or sort the persons on the bases of first name
    @Override
    public int compare(PersonResources o1, PersonResources o2) {
        return o1.firstName.compareTo(o1.lastName);
    }
}
