package com.sdyin.design.observer;

/**
 * 被观察者
 * @Description
 * @Author liuye
 * @Date 2019/7/19 14:11
 */
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyAllObserver();
}
