package org.example.JavaInterface;

public interface Java9Feature {

    void canFly();// complete abstract
   // This is introduced in java 8 feature
    public default void myDefaultMethod(){
        myStaticPublicMethod();
        myPriavateMethod();
        myPrivateStaticMethod();

    }
    /**
     * This is introduced in java 8 feature
     * from static method we can call only other static method only
     */
    static void myStaticPublicMethod(){
        myPrivateStaticMethod();
    }

    /**
     * This is introduced in java 9 feature
     * Since it is private so this can be access only within the interface
     */
    private void myPriavateMethod(){
        // implementation is here

    }

    /**
     * This is introduced in java 9 feature
     * Since it is private so this can be access only within the interface
     * it also static means it associated with interface and can
     */
    private static void myPrivateStaticMethod(){
       // implementation is here
    }

}
