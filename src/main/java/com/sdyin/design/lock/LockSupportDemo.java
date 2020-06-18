package com.sdyin.design.lock;

import java.time.LocalDateTime;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description locksupport demo
 * @Author liuye
 * @Date 2020/6/18 11:00
 **/
public class LockSupportDemo {

    public static void main(String[] args) {
        // 10 * 2的2次方
        System.out.println(10 << 2);
        // 10 * 2的3次方
        System.out.println(10 << 3);
        System.out.println(LocalDateTime.now() + ":主线程开始执行");
        LockSupport.parkNanos(1000 * 1000 * 1000);
        System.out.println(LocalDateTime.now() + ":主线程执行完毕");

        Thread t1 = new Thread(() ->{
            System.out.println(LocalDateTime.now() + ":" +Thread.currentThread().getName() + "开始执行");
            LockSupport.park();
            System.out.println(LocalDateTime.now() + ":" +Thread.currentThread().getName() + "执行完成");
        },"sdyin");
        Thread t2 = new Thread(() ->{
            System.out.println(LocalDateTime.now() + ":" +Thread.currentThread().getName() + "开始执行");
            LockSupport.parkNanos(1000 * 1000 * 1000);
            LockSupport.unpark(t1);
            System.out.println(LocalDateTime.now() + ":" +Thread.currentThread().getName() + "执行完成");
        },"ruimeng");
        t1.start();
        t2.start();

    }
}
