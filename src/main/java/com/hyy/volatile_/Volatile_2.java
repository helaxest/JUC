package com.hyy.volatile_;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/22  8:23
 * @since
 */
@SuppressWarnings({"all"})
public class Volatile_2 {
//    public static volatile int num=1;
    public static volatile AtomicInteger num=new AtomicInteger();
//    public synchronized static void  add(){
//        num++;
//    }
    public  static void  add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {


        for (int i = 1; i <=10; i++) {
            new Thread(()->{
                for (int j = 0; j < 2000; j++) {
                    add();
                }
            }).start();
        }


       while (Thread.activeCount()>2){//( gc - mian)
           Thread.yield();
       }
        System.out.println(num);
    }
}
