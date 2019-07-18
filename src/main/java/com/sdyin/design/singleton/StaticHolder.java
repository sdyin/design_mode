package com.sdyin.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 静态内部类 单例模式
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:46
 */
public class StaticHolder {

    private StaticHolder(){
    }

    public static class Holder{
        public static StaticHolder instance = new StaticHolder();
    }

    public static StaticHolder getInstance(){
        return Holder.instance;
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExcutor = ThreadPoolUtils.getThreadPool();
        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            poolExcutor.submit(()->{
                StaticHolder instance = StaticHolder.getInstance();
                System.out.println(instance);
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println("执行完成");
        poolExcutor.shutdown();
    }

}
