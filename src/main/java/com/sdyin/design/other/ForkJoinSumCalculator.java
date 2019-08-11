package com.sdyin.design.other;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Description
 * @Author liuye
 * @Date 2019/8/10 15:19
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long>{

    //求和数组
    private final long[] numbers;

    //开始位置
    private final int start;

    //结束位置
    private final int end;

    public static final long THRESHOLD = 100000;

    /**
     * 公共构造函数:创建主任务
     * @param numbers
     */
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers,0,numbers.length);
    }

    /**
     * 私有函数递归子函数
     * @param numbers
     * @param start
     * @param end
     */
    private ForkJoinSumCalculator(long[] numbers,int start,int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= THRESHOLD){
            return computeSequentially();
        }
        System.out.println("------- curentThread:" + Thread.currentThread().getName());
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        rightTask.fork();
        //合并
        return leftTask.join() + rightTask.join();
    }

    /**
     * 计算
     * @return
     */
    private long computeSequentially(){
        long sum = 0;
        for (int i = start; i< end; i++){
            sum += numbers[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long n = 100000000L;
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
        long start = System.currentTimeMillis();
        Long result = new ForkJoinPool().invoke(task);
        long end = System.currentTimeMillis();
        System.out.println("result:"+ result);
        System.out.println("forkJoin spend time:" + (end -start));

        int sum = 0;
        long start2 = System.currentTimeMillis();
        for (int i = 0;i <= n;++i) {
            sum += i;
        }
        long end2 = System.currentTimeMillis();
        System.out.println("sum:"+ sum);
        System.out.println("for spend time:" + (end2 -start2));
    }
}
