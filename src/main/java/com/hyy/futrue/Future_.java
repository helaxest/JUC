package com.hyy.futrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  19:07
 * @since
 */
public class Future_ {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getState());
//        });
//        System.out.println("32332131");
//        completableFuture.get();



        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getState());
            int a=10/0;
            return 2556;
        });


        System.out.println(completableFuture.whenComplete((t,u)->{
            System.out.println("t===="+t);//2222
            System.out.println("u===="+u);//null
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return 23;
        }).get());


    }
}
