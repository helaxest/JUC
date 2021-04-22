package com.hyy.volatile_;

import java.util.concurrent.TimeUnit;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/22  8:23
 * @since
 */
public class Volatile_ {
//    public static volatile int num=1;
    public static  int num=1;
    public static void main(String[] args) {
        new Thread(()->{
            while (num==1){

            }
        }).start();


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num=0;
        System.out.println(num);
    }
}
