package com.sdyin.design.other;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock 提供的乐观读,同时允许一个线程写,即写线程不是全阻塞
 * StampedLock 悲观读写锁都不支持 条件变量
 * @Description
 * @Author liuye
 * @Date 2019/8/8 19:19
 */
public class StampedLockDemo {

    private static int x, y;

    static final StampedLock s1 = new StampedLock();

    public static void main(String[] args) {

        //普通读锁
        long stamp = s1.readLock();
        try {
            System.out.println("进入读锁");
        } finally {
            s1.unlockRead(stamp);
        }
        //普通写锁
        long stamp2 = s1.writeLock();
        try {
            System.out.println("进入写锁");
        } finally {
            s1.unlockWrite(stamp2);
        }

        //乐观读
        long stamp3 = s1.tryOptimisticRead();
        int curX =x;
        int curY = y;
        //读操作期间,存在写操作 validate 方法会返回false
        if(!s1.validate(stamp3)){
            //升级为悲观读
            stamp3 = s1.readLock();
            try {
                System.out.println("执行悲观读");
                curX = x;
                curY = y;
            } finally {
                s1.unlockRead(stamp3);
            }
        }

        System.out.println("result:" + curX + curY);
    }
}
