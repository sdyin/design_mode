package com.sdyin.design.lock.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 无锁版本-生产者消费者模型
 * @Author: liuye
 * @time: 2020/6/15$ 上午5:58$
 */

public class NoLockProviderConsumerDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue(10));
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始准备生产");
                myResource.provider();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "开始准备消费");
                myResource.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BBB").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {

        }
        System.out.println("要准备停止啦");
        myResource.stop();
    }
}

/**
 * 资源类
 */
class MyResource{

    private volatile boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue;

    public MyResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产者
     */
    public void provider() throws Exception{
        boolean b;
        int i;
        while(flag){
            i = atomicInteger.incrementAndGet();
            b = blockingQueue.offer(atomicInteger + "");
            if(b){
                System.out.println("生产成功:" + i);
            }else{
                System.out.println("生产失败:" + i);
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("停止生产");
    }

    /**
     * 消费者
     */
    public void consumer() throws Exception{
        String data = null;
        while(flag){
            data = blockingQueue.poll(2, TimeUnit.SECONDS);
            if(data == null || "".equalsIgnoreCase(data)){
                System.out.println("超过2s没有取到消费值,退出消费");
                flag = false;
                return;
            }
            System.out.println("消费当前值：" + data);
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("停止消费");
    }

    /**
     * 停止生产
     */
    public void stop(){
        flag = false;
    }
}
