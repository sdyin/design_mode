package com.sdyin.design.other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/21$ 下午9:41$
 */
public class LockTest {

    public static void main(String[] args) {

        Thread thread = new Thread();
        //thread.wait();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();


    }
}
