package com.sdyin.design.other.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description 继承AQS实现共享锁
 * @Author liuye
 * @Date 2019/8/17 19:26
 */
public class ShareLock implements Lock{

     private final Sync sync = new Sync(2);

    private static class Sync extends AbstractQueuedSynchronizer {
        Sync(int count){
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (;;){
                int current = getState();
                int newCurrent = current - arg;
                if(newCurrent >= 0 && compareAndSetState(newCurrent,current)){
                    return newCurrent;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (;;){
                int current = getState();
                int newCurrent = current + arg;
                if(newCurrent >= 0 && compareAndSetState(newCurrent,current)){
                    return true;
                }
            }
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.tryAcquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1) >= 0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.tryReleaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

}
