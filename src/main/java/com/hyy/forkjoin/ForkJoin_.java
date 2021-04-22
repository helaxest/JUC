package com.hyy.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Description
 *
 * @author helaxest
 * @date 2021/04/21  18:24
 * @since
 */
public class ForkJoin_ extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    private Long temp = 10000L;

    public ForkJoin_(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println(sum);
            return sum;
        } else {
            long l = (end + start) / 2;
            ForkJoin_ t1 = new ForkJoin_(start, l);
            t1.fork();
            ForkJoin_ t2 = new ForkJoin_(l, end);
            t2.fork();
            return t1.join() + t2.join();
        }

    }



}
