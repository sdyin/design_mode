package com.sdyin.design.other.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * @Description 继承AQS实现独占锁
 * @Author liuye
 * @Date 2019/8/17 17:18
 */
public class AloneLock {

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg){
            //首先判断状态是否等于=0,如果状态==0，就将status设置为1
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg){
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }

        //是否在独占模式下被线程占用
        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }

        protected Condition newCondiction(){
            return new ConditionObject();
         }
    }

    /**
     * 加锁
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 非阻塞加锁
     * @return
     */
    public boolean tryLock(){
        return sync.tryAcquire(1);
    }

    /**
     * 可中断加锁
     * @throws InterruptedException
     */
    public void lockInterrupt() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public boolean tryLockTimeOut(long times,TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(times));
    }
    /**
     * 释放锁
     */
    public void unlock() {
        sync.release(1);
    }

    /**
     * 判断是否占有锁
     */
    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

    public Condition newCondition(){
        return sync.newCondiction();
    }

}
