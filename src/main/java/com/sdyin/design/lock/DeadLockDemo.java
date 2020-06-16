package com.sdyin.design.lock;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/6/16$ 下午8:11$
 */
public class DeadLockDemo {

    private String lock1 = "lock1";
    private String lock2 = "lock2";

    public static void main(String[] args) {
        DeadLockDemo lockDemo = new DeadLockDemo();

        new Thread(() -> {
            synchronized (lockDemo.lock1){
                System.out.println(Thread.currentThread().getName() + "获取到锁"+ lockDemo.lock1);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "尝试获取到锁"+ lockDemo.lock2);
                synchronized (lockDemo.lock2){
                    System.out.println(Thread.currentThread().getName() + "获取到锁"+ lockDemo.lock2);
                }
            }
        },"sdyin").start();

        new Thread(() -> {
            synchronized (lockDemo.lock2){
                System.out.println(Thread.currentThread().getName() + "获取到锁"+ lockDemo.lock2);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "尝试获取到锁"+ lockDemo.lock1);
                synchronized (lockDemo.lock1){
                    System.out.println(Thread.currentThread().getName() + "获取到锁"+ lockDemo.lock1);
                }
            }
        },"ruimeng").start();

        System.out.println("主线程执行完毕");
    }
}
