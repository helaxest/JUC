package com.hyy.lock8;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  10:40
 * @since
 */
public class Test {
    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(phone::sendMS, "ms").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(phone::call, "call").start();


    }
}

class Phone {
    public synchronized void sendMS() {
        System.out.println("sendMS");
    }

    public synchronized void call() {
        System.out.println("call");

    }


}