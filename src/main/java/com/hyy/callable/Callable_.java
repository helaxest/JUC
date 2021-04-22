package com.hyy.callable;

import com.hyy.demo1.Main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  15:03
 * @since
 */
public class Callable_ {
    public static void main(String[] args) {
        FutureTask futureTask=new FutureTask(new A());
        new Thread(futureTask, "a").start();
        try {
            String o = (String) futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
class A implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println(2112);
        return "null";
    }
}