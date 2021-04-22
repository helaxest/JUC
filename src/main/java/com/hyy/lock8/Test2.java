package com.hyy.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  10:40
 * @since
 */
public class Test2 {
    public static void main(String[] args) {

        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();

        new Thread(() -> {
            phone1.sendMS();
        }, "ms").start();

        new Thread(phone2::hello, "call").start();


    }
}

class Phone2 {
    static int num=2;
    public synchronized void sendMS() {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信"+num);
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName());
    }

    public synchronized void hello() {
        num=3;
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}