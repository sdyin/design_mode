package com.sdyin.design.other.aqs;

import com.sdyin.design.singleton.ThreadPoolUtils;

import java.time.Instant;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author liuye
 * @Date 2019/8/17 17:33
 */
public class TestLock {

    public static int count = 0;

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = ThreadPoolUtils.getThreadPool();
        AloneLock aloneLock = new AloneLock();

        long startTime = Instant.now().toEpochMilli();
        System.out.println();
        for (int i = 0;i< 500;i++){
            threadPool.submit(()-> ++count);
        }
        long endTime = Instant.now().toEpochMilli();
        System.out.println("count:" + count + " -- spend time:" + (endTime - startTime));

        count = 0;
        long startTime2 = System.currentTimeMillis();
        System.out.println();
        for (int i = 0;i< 500;i++){
           threadPool.submit(()-> {
               try {
                   aloneLock.lock();
                   ++count;
               } finally {
                   aloneLock.unlock();
               }
           });
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("lock count:" + count + " -- spend time:" + (endTime2 - startTime2));

    }
}
