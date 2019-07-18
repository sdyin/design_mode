package com.sdyin.design.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 饿汉式- 线程安全
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:17
 */
public class HungrySafe {

    private static HungrySafe instance = new HungrySafe();

    private HungrySafe(){
    }

    public static HungrySafe getInstance(){
        if(instance == null){
            return new HungrySafe();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExcutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            poolExcutor.submit(()->{
                HungrySafe instance = HungrySafe.getInstance();
                System.out.println(instance);
            });
        }
        cdl.await();
        System.out.println("执行完成");
    }

}
