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
public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();
        int num = 100;
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.printA();
            }
        }, "a").start();
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.printB();
            }
        }, "b").start();
        new Thread(() -> {
            for (int i = 0; i < num; i++) {
                data.printC();
            }
        }, "c").start();



    }
}

@SuppressWarnings({"all"})
class Data3 {
    int num = 1;

    Lock lock = new ReentrantLock(false);
    Condition c1 = lock.newCondition();//a
    Condition c2 = lock.newCondition();//b
    Condition c3 = lock.newCondition();//c

    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                //wait
                c1.await();
            }
            //业务
            System.out.println(Thread.currentThread().getName() + "==>" + num);

            num = 2;
            c2.signal();//通知
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (num != 2) {
                //wait
                c2.await();
            }
            //业务
            System.out.println(Thread.currentThread().getName() + "==>" + num);

            num = 3;
            c3.signal();//通知
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (num != 3) {
                //wait
                c3.await();
            }
            System.out.println(Thread.currentThread().getName() + "==>" + num);

            //业务
            num = 1;
            c1.signal();//通知
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

