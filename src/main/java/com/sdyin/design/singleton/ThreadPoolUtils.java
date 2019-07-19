package com.sdyin.design.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:29
 */
public class ThreadPoolUtils {

    public static Integer i = 0;

    public static ThreadPoolExecutor getThreadPool(){
        ThreadPoolExecutor poolExcutor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setDaemon(true);
                    thread.setName("sdyin_thread_pool_" + (++i));
                    return thread;
                });
        return poolExcutor;
    }
}
