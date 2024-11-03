package org.example.ThreadPoolExecutorExample;


import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args){
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 2, 5L, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


            CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
                return "task complete";
            }, poolExecutor);

            System.out.println(asyncTask1.get());


            /**
             * thenApply and thenApplyAsync
             * apply function to the result of previous async computation
             * Note: in both task executed by same thread
             *
             */

            CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(()->{
                System.out.println("asyncTask 2 executed by "+ Thread.currentThread().getName());
                return "task1 completed";
            }, poolExecutor);

           CompletableFuture<String> finalTask  =  asyncTask2.thenApply((String val)->{
               System.out.println("finalTask  executed by "+ Thread.currentThread().getName());
             return  val + " with then apply";
            });

           System.out.println(finalTask.get());

            /**
             * both same but if both task complete by different thread we can use this
             *
             */

            System.out.println("Both task1 and finalTask1 executed by different thread");
            CompletableFuture<String> finalTask1  =  asyncTask2.thenApplyAsync((String val)->{
                System.out.println("finalTask executed by thread:  "+ Thread.currentThread().getName());
                return  val + " with then apply";
            });

            System.out.println(finalTask1.get());



            // thenCompose() and thenComposeAsync
            /**
             * Used to when ordering is required in async tasks
             * In this case task operation is depends on the result of previous async task
             */

            CompletableFuture<String> asyncTask4 = CompletableFuture.supplyAsync(()->{
                System.out.println("Thread name which run supplyAsync: "+ Thread.currentThread().getName());
                return "This is Task1 ";
            }, poolExecutor);

            // Using the thenCompose method
            CompletableFuture<String> asyncTask5 =  asyncTask4.thenCompose((String val)->{
                System.out.println("Thread name which run thenCompose: "+ Thread.currentThread().getName());
                // this return the CompletionStage below so we can use the another CompletableFuture
                return  CompletableFuture.supplyAsync(()->{
                    return val + "order with thenCompose()";
                });
            });
            System.out.println(asyncTask5.get());

            // Using the thenComposeAsync() method
            CompletableFuture<String> asyncTask6 =  asyncTask4.thenComposeAsync((String val)->{
                System.out.println("Thread name which run thenComposeAsync: "+ Thread.currentThread().getName());
                // this return the CompletionStage below so we can use the another CompletableFuture
                return  CompletableFuture.supplyAsync(()->{
                    return val + "order with thenComposeAsync1() ";
                });
            }, poolExecutor).thenComposeAsync((String val)-> {
                        System.out.println("Thread name which run thenComposeAsync 2: " + Thread.currentThread().getName());
                        // this return the CompletionStage below so we can use the another CompletableFuture
                        return CompletableFuture.supplyAsync(() -> {
                            return val + "order with thenComposeAsync2()";
                        });
                    }, poolExecutor);

            System.out.println(asyncTask6.get());

            /**
             * ThenAccept() and thenAcceptAsync()
             * this is the end stage, which do not return anythinh
             * OR we can say when we need to end the chain. we use this because it does not return anything
             */

            asyncTask6.thenAccept((String val)->{
                System.out.println("thenAccept() Thread name "+ Thread.currentThread().getName());
                System.out.println("ending the chain or completed the all task using thenAccept()");
            });
            asyncTask6.thenAcceptAsync((String val)->{
                System.out.println("thenAcceptAsync() Thread name "+ Thread.currentThread().getName());
                System.out.println("ending the chain or completed the all task using the thenAcceptAsync ");
            }, poolExecutor);

            System.out.println(asyncTask6.get());

            /**
             * ThenCombine() and thenCombineAsync()
             * Used for to combine the result of 2 comparableFuture task
             */

            CompletableFuture<Integer> task1Async = CompletableFuture.supplyAsync(()-> {
                System.out.println("task1 Thread name "+ Thread.currentThread().getName());
                        return 16;
                    }, poolExecutor);

            CompletableFuture<String> task2Async = CompletableFuture.supplyAsync(()-> {
                System.out.println("task2 Thread name "+ Thread.currentThread().getName());
                return " Sixteen";
            }, poolExecutor);

            //use the combine

            CompletableFuture<String> result = task1Async.thenCombine(task2Async, (Integer val1, String val2) ->{
                System.out.println("thenCombine() Thread name "+ Thread.currentThread().getName());
                return  val1 + val2;
            });
            System.out.println(result.get());
            CompletableFuture<String> result2 = task1Async.thenCombineAsync(task2Async, (Integer val1, String val2) ->{
                System.out.println("thenCombineAsync() Thread name "+ Thread.currentThread().getName());
                return  val1 + val2;
            }, poolExecutor);

            System.out.println(result2.get());





        } catch (Exception ignored){
            System.out.println("some exception occurred " + ignored);
        }

    }
}
