package com.sdyin.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 饿汉式-双重检查锁
 * @Description
 * @Author liuye
 * @Date 2019/7/18 19:21
 */
public class DoubleCheckSafe {

    private static volatile DoubleCheckSafe instance;

    private DoubleCheckSafe(){
    }

    public static DoubleCheckSafe getInstance(){
        if(instance == null){
            synchronized (DoubleCheckSafe.class){
                if(instance == null){
                    return new DoubleCheckSafe();
                }
            }
        }
        return instance;
    }

}
