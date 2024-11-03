package org.example.JavaInterface;

/**
 * If an interface contains only one abstract method called functional interface
 * OR
 * SAM (Single Abstract Method)
 * @FunctionalInterface keyword can be used top of the interface but it is optional.
 */

@FunctionalInterface
public interface FunctionalInterfaceTest {

    public void canFly(String value); // abstract method

    // non -abstract method because it also has implementation
   public default void getMinimumFlyHeight(){
       System.out.println("test method");
   }

   public static int numberOfEyes(){
       return 3;
   }

   String toString(); // object class method
}
