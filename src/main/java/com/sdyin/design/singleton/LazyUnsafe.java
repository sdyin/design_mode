package com.sdyin.design.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 懒汉式: 线程不安全
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:05
 */
public class LazyUnsafe {

    private static LazyUnsafe instance;

    private LazyUnsafe(){
    }

    public static LazyUnsafe getInstance(){
        if(instance == null){
            return new LazyUnsafe();
        }
        return instance;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExcutor = ThreadPoolUtils.getThreadPool();
        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            poolExcutor.submit(()->{
                LazyUnsafe instance = LazyUnsafe.getInstance();
                System.out.println(instance);
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println("执行完成");
        poolExcutor.shutdown();
    }


}
