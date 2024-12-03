package org.example.SingletonClassExamples;

import java.util.Hashtable;

public class LazySingleton {
    private static volatile LazySingleton lazySingleton;

    private LazySingleton(){

    }

    /**
     * This is method has disadvantage, it two thread comes paralled in same time, sayd
     * thread1 found lazySingleton is null and created new instance of object;
     * Thread2 also found lazySingleton is null it also create new instance of object;
     * Two instance of object is created which voilets the singleton class purpose.
     *
     * @return
     */
    public static LazySingleton getLazySingletonInstance(){
        if(lazySingleton == null){
            lazySingleton =  new LazySingleton();
        }return lazySingleton;
    }

    /**
     * To overcome with this problem we use the Synchronization method
     * Disadvantage: since we put the lock on method level so it become very slow.
     * To overcome with this problem we use the double check lock;
     */

   synchronized public static LazySingleton getLazySingletonInstance1(){
        if(lazySingleton == null){
            lazySingleton =  new LazySingleton();
        }return lazySingleton;
    }

    /**
     * Use the doubleCheck lock OR block level synchronization
     */

    public static LazySingleton getLazySingletonDoubleLockInstance(){
        if (lazySingleton == null){
            synchronized (LazySingleton.class){
                if(lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
