package org.example.SingletonClassExamples;

public class EagerSingleton {
    /**
     * this is called eager initialization because we initialise the variable with static keyword.
     * Note: when application start all static variabel preloaded into memory
     * Due to which when application start it loads into the memory. and object is created using new keyword.
     */
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private  EagerSingleton(){
    }
    public static EagerSingleton getEagerSingletonInstances(){
        return eagerSingleton;
    }
}
