package org.example.ThreadPoolExecutorExample;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
       // th.setName("customThread");
        th.setDaemon(false);
        return th;
    }
}
