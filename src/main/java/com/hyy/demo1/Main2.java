package com.hyy.demo1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  7:55
 * @since
 */
@SuppressWarnings({"all"})
public class Main2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
        }, "C").start();


    }
}

class Ticket2 {
    public int num = 90;
    //    Lock lock = new ReentrantLock();
    //    Lock lock = new ReentrantLock(true);
          Lock lock = new ReentrantLock(false);

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "  " + num + " 剩余" + (--num));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

