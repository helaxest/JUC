package com.hyy.add;

import sun.awt.SunHints;

import java.util.concurrent.CountDownLatch;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  15:08
 * @since
 */
public class CountDownLatch_ {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"GO");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();//减法计数器
        System.out.println("125656");

    }
}
