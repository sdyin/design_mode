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
        //参数1： blocker 非静态方法中建议传入this
        //park的三种形式也支持blocker对象参数。 线程被阻止时记录此对象，以允许监视和诊断工具识别线程被阻止的原因。
        // （此类工具可以使用方法getBlocker(Thread)访问阻止程序 。）强烈鼓励使用这些形式而不是没有此参数的原始形式。
        // 在锁实现中作为blocker提供的正常参数是this 。
        LockSupport.parkNanos(LockSupportDemo.class,1000 * 1000 * 1000);
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
