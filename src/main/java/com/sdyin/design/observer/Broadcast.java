package com.sdyin.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 广播
 * @Description
 * @Author liuye
 * @Date 2019/7/19 14:17
 */
public class Broadcast implements Subject{

    private List<Observer> observers;

    private String content;

    public Broadcast() {
        observers = new ArrayList<>();
    }

    public void setContent(String content) {
        this.content = content;
        notifyAllObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer: observers) {
            observer.update(content);
        }
    }
}
