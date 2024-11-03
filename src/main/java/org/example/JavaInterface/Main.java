package org.example.JavaInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args){


        //Implement using "anonymous" class;
        FunctionalInterfaceTest testObjectAnonymous = new FunctionalInterfaceTest() {
            @Override
            public void canFly(String value) {
                System.out.println("Functional interface implementation using anonymous class");
            }
        };
        testObjectAnonymous.canFly("by Anonymous class");



        //Implement using lambda expression
        FunctionalInterfaceTest testObject = (String val)->{
            //Implementation here as per requirement;
            System.out.println("Functional interface implementation using lambda expression");
        };

        testObject.canFly("testObject can fly vertically");


         /**
         * Type of functional Interface
         * Present in package java.util.function;
         */

         //Consumer
        Consumer<Integer> consumerObject = (Integer val)->{
            if(val>10){
                System.out.println("Yes I got greater the 10 number");
            }
        };

        consumerObject.accept(12);


        //Supplier
        Supplier<String> supplierObject = ()-> {
            System.out.println("Yes I am supplyin whatever i got");
            return "Yes I am supplying whatever i got";
        };

        System.out.println(supplierObject.get());


        //Function
        Function<Integer, String> functionObject = (Integer val)->{
            if(val%2 == 0){
                return "even";
            }else{
                return "odd";
            }
        };
        System.out.println(functionObject.apply(15));


        //Predicate
        Predicate<Integer> predicateObject = (Integer val)->{
            if(val%2 == 0){
                return true;
            }else {
                return false;
            }
        };

        System.out.println("value is even :" + predicateObject.test(16));
    }
}
