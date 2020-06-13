package com.sdyin.design.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 生产者-消费者模型示例
 * @Author: liuye
 * @time: 2020/6/13$ 下午7:57$
 */
public class ProviderConsumerDemo {

    private volatile int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    /**
     * 生产
     *
     * @throws Exception
     */
    private void provider(){
        try {
            lock.lock();
            //不为0，已经生成 阻塞等待消费
            while (number != 0) {
                condition.await();
            }
            ++number;
            System.out.println(Thread.currentThread().getName() + "生产一次,number =" + number);
            condition.signalAll();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费
     *
     * @throws Exception
     */
    private void consumer(){
        try {
            lock.lock();
            //不为0，已经生成 阻塞等待消费
            while (number == 0) {
                condition.await();
            }
            --number;
            System.out.println(Thread.currentThread().getName() + "消费一次, number =" + number);
            condition.signalAll();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProviderConsumerDemo demo = new ProviderConsumerDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    demo.provider();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "sdyin").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    demo.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "ruimeng").start();
        }

    }
}

