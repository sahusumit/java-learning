package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");

        multiply multiply = new multiply();

        String n1 ="123456789098765432101234567890987654321012345678905533557711990077123455432171717053169";
        String n2 ="101037379572958672048675927605967298575748627486749874810495847876810496710491510101010000101010111";
        String ans = multiply.multiplyTwoStrings(n1,n2);
        System.out.println(ans);


        MaxSumFromList maxSumFromList = new MaxSumFromList();
       int[] arr =  new int[] {3, 2, 5, 10, 7};
        int ans1 = maxSumFromList.SticklerThief(arr, arr.length);
        System.out.println("max sum will be: "+ ans1);

        List<Integer> ls = new ArrayList<>();
        ls.add(3);
        ls.add(2);
        ls.add(4);
        ls.add(5);
        ls.add(6);

        List<Integer> l2 = ls.subList(1, ls.size());
        System.out.println(l2);

    }
}