package com.sdyin.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:40
 */
public class TestSingle {

    /**
     * 测试各种单例模式
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExcutor = ThreadPoolUtils.getThreadPool();
        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            poolExcutor.submit(()->{
                DoubleCheckSafe instance = DoubleCheckSafe.getInstance();
                System.out.println(instance + " --- " + Thread.currentThread().getName());
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println("执行完成");
        poolExcutor.shutdown();
    }
}
