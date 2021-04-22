package com.hyy.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  15:20
 * @since
 */
public class CyclicBarrier_ {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100,()->{
            System.out.println("。。。。。。。。。。。。。。。。。。。。");
        });
        for (int i =0; i <= 8; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"GO"+temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        System.out.println("125656");
    }
}
