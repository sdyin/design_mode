package com.sdyin.design.lock;

import com.sdyin.design.singleton.ThreadPoolUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description 自旋锁demo
 * @Author liuye
 * @Date 2020/6/7 21:54
 **/
public class SpinLockDemo {

    public AtomicReference<Thread> atomicReference = new AtomicReference();

    public void lock() {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "尝试加锁");
        while (!atomicReference.compareAndSet(null, thread)) {

        }

        System.out.println(thread.getName() + "加锁成功");

    }

    public void unlock() {

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "解锁");

        atomicReference.compareAndSet(thread, null);
    }


    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();


        //直接创建线程方式
        new Thread(() -> {
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {

            }
            spinLockDemo.unlock();
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }

        new Thread(() -> {
            spinLockDemo.lock();
            spinLockDemo.unlock();
        }, "t2").start();



        //线程池方式，注意线程池方式是有守护线程，主线程执行完毕，jvm会随之退出
        ThreadPoolUtils.getThreadPool().execute(() ->{
            spinLockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {

            }
            spinLockDemo.unlock();
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }

        ThreadPoolUtils.getThreadPool().execute(() ->{
            spinLockDemo.lock();
            spinLockDemo.unlock();
        });

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {

        }

        System.out.println("主线程执行完毕");

    }
}
