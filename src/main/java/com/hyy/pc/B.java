package com.hyy.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  9:39
 * @since
 */
@SuppressWarnings({"all"})
public class B {
    public static void main(String[] args) {
        Data2 data = new Data2();
        int num = 100;
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.increment();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.decrement();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.increment();
            }
        }, "c").start();
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.decrement();
            }
        }, "d").start();
    }
}

@SuppressWarnings({"all"})
class Data2 {
    int num = 0;

    Lock lock = new ReentrantLock(false);
    Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (num != 0) {
                //wait
                condition.await();
            }
            //业务
            num++;
            condition.signalAll();//通知
            condition.signal();
            System.out.println(Thread.currentThread().getName() + "==>" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement()  {
        lock.lock();
        try {
            while (num == 0) {
                //wait
                condition.await();
            }
            num--;
            condition.signalAll();//通知
            System.out.println(Thread.currentThread().getName() + "==>" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

