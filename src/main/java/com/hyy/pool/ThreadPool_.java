package com.hyy.pool;

import java.util.concurrent.*;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  16:47
 * @since
 */
public class ThreadPool_ {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool =   Executors.newScheduledThreadPool(1);
        ArrayBlockingQueue<Runnable> wait = new ArrayBlockingQueue<>(5);//等候
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                wait,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        /**
         * ThreadPoolExecutor.AbortPolicy()
         * ThreadPoolExecutor.CallerRunsPolicy()
         * ThreadPoolExecutor.DiscardPolicy()
         */

        /**
         *       Runtime.getRuntime().availableProcessors() cpu 密集型
         *                                                     IO 密集型
         */
        Executors.newFixedThreadPool(2);
        Executors.newSingleThreadExecutor();
        try {
            for (int i = 1; i < 15; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            System.out.println("wdnmd");
//            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        System.out.println(threadPool.isShutdown());

    }
}
