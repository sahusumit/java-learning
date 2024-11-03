package org.example.SingletonClassExamples;


/**
 * This is not use synchronization or volatile keywords that is why it is very fast.
 * This is very popular to use because this is very fast
 * This is use the private static nested class and nested class has property that it will not load in memory during the
 * application start. it is initialized when it called;
 */
public class BillPughSingleton {
    private BillPughSingleton(){

    }
    private static class BillPughSingletonHelper{
        private static final BillPughSingleton CONFIG_OBJECT = new BillPughSingleton();
    }

    public static BillPughSingleton getBillPughSingletonInstance(){
        return BillPughSingletonHelper.CONFIG_OBJECT;
    }
}
