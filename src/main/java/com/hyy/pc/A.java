package com.hyy.pc;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  9:39
 * @since
 */
@SuppressWarnings({"all"})
public class A {
    public static void main(String[] args) {
        Data data=new Data();
        int num=100;
        new Thread(()->{
            for (int i = 0; i <num; i++) {
                data.increment();
            }
        }, "a").start();
        new Thread(()->{
            for (int i = 0; i < num; i++) {
                data.decrement();
            }
        }, "b").start();
    }
}
@SuppressWarnings({"all"})
class Data{
    int num=0;

    public synchronized void increment(){
        while (num!=0){
            //wait
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //业务
        num++;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+"==>"+num);

    }

    public synchronized void decrement(){
        while (num==0){
            //wait
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+"==>"+num);

    }

}

