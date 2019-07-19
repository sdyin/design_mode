package com.sdyin.design.observer;

import org.springframework.aop.scope.ScopedProxyUtils;

/**
 * @Description
 * @Author liuye
 * @Date 2019/7/19 14:27
 */
public class PersonB implements Observer{
    @Override
    public void update(String content) {
        System.out.println("personB 接收到内容:" + content);
    }

}
