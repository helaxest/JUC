package com.hyy.demo1;


/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  7:55
 * @since
 */
@SuppressWarnings({"all"})
public class Main {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i <50 ; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <60 ; i++) {
                ticket.sale();
            }
        },"C").start();



    }
}
class Ticket {
    public int num = 10;

    public synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "  " + num + " 剩余" + (--num));

        }
    }

}