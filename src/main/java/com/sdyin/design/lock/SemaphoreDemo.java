package com.sdyin.design.lock;

import com.sdyin.design.singleton.ThreadPoolUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liuye
 * @time: 2020/6/10$ 下午10:58$
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            ThreadPoolUtils.getThreadPool().execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到资源,开始执行");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "执行完成");
                } catch (InterruptedException e) {

                }finally {
                    semaphore.release();
                }
            });
        }

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {

        }
    }
}
