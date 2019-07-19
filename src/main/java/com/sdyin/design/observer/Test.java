package com.sdyin.design.observer;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/19 14:30
 */
public class Test {

    public static void main(String[] args) {
        Broadcast broadcast = new Broadcast();
        broadcast.setContent("初始化事件");

        PersonA personA = new PersonA();
        broadcast.registerObserver(personA);
        broadcast.setContent("hello,nice to meet you");

        broadcast.registerObserver(new PersonB());
        broadcast.setContent("see you again");

        broadcast.removeObserver(personA);
        broadcast.setContent("hello personB");
    }
}
