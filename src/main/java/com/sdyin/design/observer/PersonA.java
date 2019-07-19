package com.sdyin.design.observer;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/19 14:26
 */
public class PersonA implements Observer {

    @Override
    public void update(String content) {
        System.out.println("personA 接收到内容:" + content);
    }
}
