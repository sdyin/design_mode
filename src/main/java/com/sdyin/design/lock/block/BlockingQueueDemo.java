package com.sdyin.design.lock.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Description: 阻塞队列测试类
 * @Author: liuye
 * @time: 2020/6/13$ 下午6:26$
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{
        //数组阻塞队列
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

        //失败场景-异常
        boolean boo = blockingQueue.add(1);
        Integer remove = blockingQueue.remove();

        //失败场景-特定值(true/false)
        boolean b = blockingQueue.offer(1);
        Integer poll = blockingQueue.poll();

        //失败场景-阻塞
        blockingQueue.put(2);
        Integer data = blockingQueue.take();

        //同步阻塞队列: 生产者-消费者模型，只能存储/消费一个元素
        BlockingQueue<Object> blockingQueue2 = new SynchronousQueue<>();

    }
}
