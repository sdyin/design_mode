package com.sdyin.design.other;

import com.sdyin.design.singleton.ThreadPoolUtils;

import java.util.concurrent.*;

/**
 * 使用BlockingQueue demo
 * @Description
 * @Author liuye
 * @Date 2019/8/11 10:07
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor threadPool = ThreadPoolUtils.getThreadPool();
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        Future<Integer> f1 = threadPool.submit(() -> getOrderPrice1());
        Future<Integer> f2 = threadPool.submit(() -> getOrderPrice2());
        Future<Integer> f3 = threadPool.submit(() -> getOrderPrice3());

        threadPool.execute(() -> {
            try {
                blockingQueue.put(f1.get());
                System.out.println("保存price1值入队,当前队列:" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                blockingQueue.put(f2.get());
                System.out.println("保存price2值入队,当前队列:" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(() -> {
            try {
                blockingQueue.put(f3.get());
                System.out.println("保存price3值入队,当前队列:" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 3; i++) {
            //阻塞消费,有生产者时,即消费
            Integer result = blockingQueue.take();
            threadPool.execute(()->saveOrder(result));
        }
    }

    public static Integer getOrderPrice1(){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("计算订单价格1,当前队列:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取订单价格1");
        return 1;
    }

    public static Integer getOrderPrice2(){
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("计算订单价格2,当前队列:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取订单价格2");
        return 2;
    }

    public static Integer getOrderPrice3(){
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("计算订单价格3,当前队列:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("获取订单价格3");
        return 3;
    }

    public static void saveOrder(Integer i){
        System.out.println("保存订单,订单价格:" + i);
    }
}
