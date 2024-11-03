package org.example.JavaCollections.collectionClasses;

import java.util.*;

public class MainMap {
    public void HashMapMethodsHelper(){
        Map<Integer, String> alphabetMap = new HashMap<>();
        alphabetMap.put(0, "A");
        alphabetMap.put(1, "B");
        alphabetMap.put(2, "C");
        alphabetMap.put(3, "D");
        alphabetMap.put(4, "E");
        alphabetMap.put(5, "F");


        alphabetMap.putIfAbsent(null,"nullable value");
        alphabetMap.putIfAbsent(27,"a");
        alphabetMap.putIfAbsent(6,"G");

        String value = alphabetMap.get(2);
        System.out.println("alphabet mapped with key 2:"+ value);

        System.out.println("Iterate the HashMap");
        for(Map.Entry<Integer, String> map : alphabetMap.entrySet()){
            Integer key = map.getKey();
            String val = map.getValue();
            System.out.println(key+ " mapped with-> "+ val);
        }
        System.out.println("map is empty: isEmpty:- "+ alphabetMap.isEmpty());
        System.out.println("size of map is :"+ alphabetMap.size());

        System.out.println("contains key 3 ->"+ alphabetMap.containsKey(3));
        System.out.println("get(25) or default:-> "+ alphabetMap.getOrDefault(9,"default value"));

        System.out.println("remove(null)->" + alphabetMap.remove(null));


        for(Map.Entry<Integer, String> map : alphabetMap.entrySet()){
            Integer key = map.getKey();
            String val = map.getValue();
            System.out.println(key+ " mapped with-> "+ val);
        }

        //Key set
        for(Integer key: alphabetMap.keySet()){
            System.out.println("key: "+key);
        }
        //values;
        Collection<String> valuesInMap = alphabetMap.values();
        for(String val: valuesInMap){
            System.out.println("values in map: "+val);
        }

    }


    public void LinkedHashMapMethodHelper(){

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(3,"A");
        map.put(5,"C");
        map.put(20,"D");
        map.put(23,"H");

        map.forEach((Integer key, String val)-> System.out.println(key+" : "+ val));

        //define the access order this can be used in cache implementation
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(16, 0.75f, true);
        map2.put(13,"Aa");
        map2.put(52,"CS");
        map2.put(25,"DJ");
        map2.put(123,"HH");
        System.out.println("Linked hasMap with access order");

        map2.forEach((Integer key, String val)-> System.out.println(key+" : "+ val));
        System.out.println("after accessing the value at 52 the it access order changes, most used add to last");
        map2.get(52);
        map2.forEach((Integer key, String val)-> System.out.println(key+" : "+ val));

    }

    public void TreeMapMethodHelper(){

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3,"A");
        map.put(5,"C");
        map.put(20,"D");
        map.put(23,"H");
        System.out.println("Tree map by default it add record as binary search tree ascending order");
        map.forEach((Integer key, String val)-> System.out.println(key+" : "+ val));

        //define the access order this can be used in cache implementation
        System.out.println("Tree map change the order using comparator as descending order");
        TreeMap<Integer, String> map2 = new TreeMap<>((Integer a, Integer b)->b-a);
        map2.put(13,"Aa");
        map2.put(52,"CS");
        map2.put(25,"DJ");
        map2.put(123,"HH");

        map2.forEach((Integer key, String val)-> System.out.println(key+" : "+ val));
    }


    public void SetMethodHelper(){

        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(26);
        set.add(77);
        set.add(45);
        set.add(67);
        System.out.println("set1 elements");
        set.forEach((Integer val)-> System.out.print(val+" ,"));
        System.out.println();
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(26);
        set2.add(73);
        set2.add(63);
        set2.add(89);
        System.out.println("set2 elements");
        set2.forEach((Integer val)-> System.out.print(val+ " ,"));
        System.out.println();

        System.out.println("addAll:union of element");
        set.addAll(set2);
        set.forEach((Integer val)-> System.out.print(val+","));
        System.out.println();

    }


}
