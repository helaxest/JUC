package com.hyy.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  18:45
 * @since
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test3();
    }

    public static void test1() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间" + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoin_ forkJoin=new ForkJoin_(0L, 10_0000_0000L);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoin);
        Long sum = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + "时间" + (end - start));
    }

    public static void test3() {
        long start = System.currentTimeMillis();
        LongStream.range(0L, 10_0000_0000L).parallel().reduce(0,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum" + (end - start));
    }
}
