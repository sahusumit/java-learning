package org.example.JavaCollections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams<T> {


    public void streamFilterMethod(List<T> dataList){

        List<Integer> list = new ArrayList<>();
        list.add(4000);
        //Count the data


        long count = list.stream().filter((Integer val) -> val >3000).count();


        //FROM COLLECTIONS
        Stream<Integer>  streamFromArrayList = list.stream();

        //FROM ARRAY
        Integer[] arr = {1,3,3,5,7,8};
        Stream<Integer> streamFromArray = Arrays.stream(arr);


        //From static method
        Stream<Integer> streamFromStaticMethod = Stream.of(1,3,3,4,5);

        //From Stream Builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(1000).add(3000).add(4000).add(3500);
        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();


        //From Stream iterator
        Stream<Integer> streamFromIterator = Stream.iterate(5000,(Integer n)->n+5000).limit(10);

    }

    public void streamIntermediateOperations(){
        String [] names = {"HELLO","EVERYBODY","HOW","ARE","YOU","DOING"};
        Stream<String> nameStream = Arrays.stream(names);
        //FILTER
        Stream<String> filterNameStream = nameStream.filter((String str)->str.length()<=3);
        List<String> filterNameList = filterNameStream.toList();
        System.out.println(filterNameList);


        //map(Function<T, R> mapper)
        Stream<String> nameStream2 = Arrays.stream(names);
        Stream<String> transformStream = nameStream2.map((String name)-> name.toLowerCase());
        List<String> transformList = transformStream.collect(Collectors.toList());
        System.out.println(transformList);


        //flatMap(Function<T, Stream<R>> mapper)
        List<List<String>> list = Arrays.asList(
                Arrays.asList("A","B","C","D"),
                Arrays.asList("E","F","G","H","K"),
                Arrays.asList("I","AM","HAPPY","NOW"));

        Stream<List<String>> listStream = list.stream();
        Stream<String> listStream1 =  listStream.flatMap((List<String> str)->str.stream());
        System.out.println(listStream1.toList());

        Stream<List<String>> listStream2 = list.stream();
       Stream<String> finalTransformStream =listStream2.flatMap((List<String> values)->values.stream().map((String val)->val.toLowerCase()));
       List<String> finalStrings = finalTransformStream.toList();
       System.out.println(finalStrings);

       //distinct
        Integer[]  arr = {1,2,4,5,6,3,6,7,3,6,7,9,3,3,2,0};

        Stream<Integer> distinctElementsStream = Arrays.stream(arr).distinct();
        System.out.println(distinctElementsStream);
        List<Integer> ans = distinctElementsStream.collect(Collectors.toList());
        System.out.println(Arrays.asList(arr) +" -> "+ans);


        //Sort the element
        Stream<Integer> unsortedArrayStream = ans.stream().sorted();
        List<Integer> sortedArray = unsortedArrayStream.toList();
        System.out.println(ans +" -> "+sortedArray);

        Stream<Integer> unsortedArrayStream1 = ans.stream().sorted();
        List<Integer> sortedArrayDescending = unsortedArrayStream1.sorted((Integer a , Integer b)->b-a).toList();
        System.out.println(ans +" -> "+sortedArrayDescending);










    }
}
