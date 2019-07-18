package com.sdyin.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 饿汉式-双重检查锁
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:21
 */
public class DoubleCheckSafe {

    private static volatile DoubleCheckSafe instance;

    private DoubleCheckSafe(){
    }

    public static DoubleCheckSafe getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSafe.class){
                if(instance == null){
                    return new DoubleCheckSafe();
                }
            }
        }
        return instance;
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExcutor = ThreadPoolUtils.getThreadPool();
        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            poolExcutor.submit(()->{
                DoubleCheckSafe instance = DoubleCheckSafe.getInstance();
                System.out.println(instance);
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println("执行完成");
        poolExcutor.shutdown();
    }
}
