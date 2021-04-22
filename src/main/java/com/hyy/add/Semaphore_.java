package com.hyy.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  15:31
 * @since
 */
public class Semaphore_ {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//线程数3
        for (int i = 1; i <=6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"ok");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"bye");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}
