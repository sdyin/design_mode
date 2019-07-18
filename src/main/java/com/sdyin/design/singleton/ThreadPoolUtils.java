package com.sdyin.design.singleton;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:29
 */
public class ThreadPoolUtils {

    public static ThreadPoolExecutor getThreadPool(){
        ThreadPoolExecutor poolExcutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100));
        return poolExcutor;
    }
}
