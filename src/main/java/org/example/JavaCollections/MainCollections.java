package org.example.JavaCollections;

import org.example.JavaCollections.collectionClasses.LinkedListExample;
import org.example.JavaCollections.collectionClasses.ListCollections;
import org.example.JavaCollections.collectionClasses.PersonResources;
import org.example.JavaCollections.collectionClasses.MainMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainCollections {
    public static void main(String[] args){

        List<Integer> values = new ArrayList<>();
        Integer [] arr = {5,7,3,8,9,11,2};
        /**
         * Sort in descending order;
         */
        System.out.println("Sort in Descending order");
        Arrays.sort(arr, (Integer a, Integer b) -> b-a);

        Arrays.stream(arr).forEach((Integer a)->System.out.println(a));

        /**
         * Sort in Ascending order
         */
        System.out.println("Sort in Ascending order");
        Arrays.sort(arr, (Integer a, Integer b) -> a-b);

        Arrays.stream(arr).forEach((Integer a)->System.out.println(a));

        List<PersonResources> personResources = new ArrayList<>();
        PersonResources p1 = new PersonResources("Sumit", "Sahu");
        PersonResources p2 = new PersonResources("Gaurav", "Kumar");
        PersonResources p3 = new PersonResources("Amit","Thakur");

        personResources.add(p1);
        personResources.add(p2);
        personResources.add(p3);

        /**
         * we can use the lambda and compareTo function;
         */
        System.out.println("Sort According to last Name");
        Collections.sort(personResources, (PersonResources obj1, PersonResources obj2) -> obj2.lastName.compareTo(obj1.lastName));
        personResources.forEach((PersonResources obj)->{System.out.println(obj.firstName+" "+ obj.lastName);});


        /**
         * or we can also use the implementing the comparator class
         */
        System.out.println("Sort According to first Name");
        Collections.sort(personResources, new PersonResources());
        personResources.forEach((PersonResources obj)->{System.out.println(obj.firstName+" "+ obj.lastName);});


        ListCollections listCollections = new ListCollections();
        listCollections.listMethods();

        LinkedListExample linkedListExample = new LinkedListExample();
        linkedListExample.LinkedListMethods();

        MainMap mainMap = new MainMap();
        mainMap.HashMapMethodsHelper();

        System.out.println("LinkedHasMap");

        mainMap.LinkedHashMapMethodHelper();
        System.out.println("Tree Map");
        mainMap.TreeMapMethodHelper();
        System.out.println("Set collection");
        mainMap.SetMethodHelper();

        System.out.println("----------------STREAMS----------------");
        JavaStreams javaStreams = new JavaStreams();
        javaStreams.streamIntermediateOperations();

    }
}
