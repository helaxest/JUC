package com.hyy.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  15:44
 * @since
 */
public class ReadWriteLock_ {
    public static void main(String[] args) {
//        MyCache myCache = new MyCache();
        MyCacheLock myCache = new MyCacheLock();
        for (int i = 1; i < 10; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.putVal(String.valueOf(temp),temp);
            },String.valueOf(i)).start();

        }
        for (int i = 1; i < 10; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.getVal(String.valueOf(temp));
            },String.valueOf(i)).start();
        }
    }
}
class MyCacheLock {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock=  new  ReentrantReadWriteLock();
    public void putVal(String s, Object o) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "写入" + s);
            map.put(s, o);
            System.out.println(Thread.currentThread().getName() + "写入ok" + s);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void getVal(String s) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取" + s);
            Object o1 = map.get(s);
            System.out.println(Thread.currentThread().getName() + "读取ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}

class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    public void putVal(String s, Object o) {
        System.out.println(Thread.currentThread().getName() + "写入" + s);
        map.put(s, o);
        System.out.println(Thread.currentThread().getName() + "写入ok" + s);
    }

    public void getVal(String s) {
        System.out.println(Thread.currentThread().getName() + "读取" + s);
        Object o1 = map.get(s);
        System.out.println(Thread.currentThread().getName() + "读取ok");
    }

}