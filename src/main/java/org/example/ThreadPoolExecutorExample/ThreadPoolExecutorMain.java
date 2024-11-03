package org.example.ThreadPoolExecutorExample;

import java.util.concurrent.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMain {
    public static void main(String[] args){

    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 5L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),
                new CustomRejectHandler());


        for(int i=1; i<=7; i++){
            executor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // handle exception here
                }
                System.out.println("Task processed by: "+ Thread.currentThread().getName());
            });
        }
        executor.shutdown();

    }
}
