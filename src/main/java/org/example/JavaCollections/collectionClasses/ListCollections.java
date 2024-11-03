package org.example.JavaCollections.collectionClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListCollections {
    public void listMethods(){

        System.out.println("listMethods(): invoked from here");
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);

        List<Integer> list2 = new ArrayList<>();
        list2.add(50);
        list2.add(60);
        list2.add(70);
        list2.add(80);

        System.out.println("Going to print list1: ");

        list1.forEach((Integer val)-> System.out.println(val));

        System.out.println("Going to print list2: ");

        list2.forEach((Integer val)-> System.out.println(val));


        list1.addAll(2, list2);



        System.out.println("Going to print list1 after add all list2 from index 2: ");
        list1.forEach((Integer val)-> System.out.println(val));


        list1.replaceAll((Integer val)-> val*3);
        System.out.println("After replace all element in list1 with element*3 ");
        list1.forEach((Integer val)-> System.out.println(val));

        System.out.println("Sort the list1 in ascending order ");
        list1.sort((Integer a, Integer b)->(a-b));
        list1.forEach((Integer val)-> System.out.println(val));

        System.out.println("Value present at index 4 is : "+ list1.get(4));


        System.out.println("set 50 at index 1");
        list1.set(1, 50);
        list1.forEach((Integer val)-> System.out.println(val));

        System.out.println("remove value from index 1");
        list1.remove(1);
        list1.forEach((Integer val)-> System.out.println(val));


        System.out.println("Index of value 120 is  : "+ list1.indexOf(120));

        ListIterator<Integer> listIterator1 = list1.listIterator(list1.size());

        while (listIterator1.hasPrevious()){
            int prevValue = listIterator1.previous();
            System.out.println("Traversing backward " + prevValue + " next index " + listIterator1.nextIndex()+
                    " previous index " + listIterator1.previousIndex());
            if(prevValue == 210){
                listIterator1.set(220);
            }
        }

        list1.forEach((Integer val)-> System.out.println(val));


        ListIterator<Integer> listIterator2 = list1.listIterator();

        while (listIterator2.hasNext()){
            int prevValue = listIterator2.next();
            System.out.println("Traversing backward " + prevValue + " next index " + listIterator2.nextIndex()+
                    " previous index " + listIterator2.previousIndex());
            if(prevValue == 210){
                listIterator2.set(220);
            }
        }

        list1.forEach((Integer val)-> System.out.println(val));
        System.out.println("sublist of of list from index 1 to 4 include 1st index and exclude the 4th index");
        List<Integer> subList = list1.subList(1,4);

        subList.forEach((Integer val)->System.out.println(val));

    }
}
