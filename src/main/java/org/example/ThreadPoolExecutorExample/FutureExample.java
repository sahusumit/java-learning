package org.example.ThreadPoolExecutorExample;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[]  args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 2, 5L, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

       Future<?> futureObj =  poolExecutor.submit(()->{
           try {
               Thread.sleep(5000);
               System.out.println("This is task , which thread will execute  with name: " + Thread.currentThread().getName());
           }catch (Exception e){
               //catch exception if occurred
           }
        });

        /**
         * .isDone() caller use to check the status or task is completed or not.
         * return type is true or false
         */
        System.out.println("Is task Done: "+ futureObj.isDone());

       try {
           /**
            * this .get(int time, TimeUnit unit)
            * method is used to check the task is completed in defined interval
            * else it throws exception.
            */
           futureObj.get(2, TimeUnit.SECONDS);
       }catch (TimeoutException | InterruptedException | ExecutionException exception){
           System.out.println("Time out exception occurred");
       }

        try {
            /**
             * this .get() method doesn't have any parameter.
             * means this caller till wait the task is completed,
             * it continuously wait till the task is not completed by thread
             */
            System.out.println("I am here");
            futureObj.get();
        }catch (InterruptedException | ExecutionException exception){
            System.out.println("Time out exception occurred");
        }

        System.out.println("Is task Done: "+ futureObj.isDone());
        System.out.println("check task is cancelled status "+ futureObj.isCancelled());

        /**
         * Runnable and callable interface
         *
         * Runnable do not has return type
         * Callable has return type it return something
         */

        // It do not return anything that's why use the wild card '?' i.e. Future<?>
        Future<?> futureObj1 = poolExecutor.submit(()->System.out.println("call from submit(Runnable) method"));
        System.out.println(futureObj1); // this always print null, because it is not return anything type void


        // It is return type is Integer
        Future<Integer> futureObj2 = poolExecutor.submit(()->{
            System.out.println("call from submit(Callable<T>) method");
            return 45;
        });


        /**
         * Use of submit(Runnable, T)
         * 1. runable it runable interface, and T is result
         * means it has runnable interface and a result
         * below example
         */

        List<Integer> myListOutput = new ArrayList<>();
        Future<List<Integer>> futureObj3 = poolExecutor.submit(new MyRunnable(myListOutput), myListOutput);


        try{
            futureObj3.get(); // call this because it will wait till the task is complete.
            // method 1. to print the result
            System.out.println("method1: output will add the value : "+ myListOutput.getFirst());
            // method to
            List<Integer> result = futureObj3.get();
            System.out.println("method2: output will add the value : "+ result.getFirst());
        }catch (Exception e){
            //
        }

    }
}
