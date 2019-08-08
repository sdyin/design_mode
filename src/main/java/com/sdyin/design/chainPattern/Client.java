package com.sdyin.design.chainPattern;

/**
 * @Description 测试责任链模式
 * @Author liuye
 * @Date 2019/8/8 10:37
 */
public class Client {

    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler();
        Handler h2 = new ConcreteHandler();
        //没有下一对象应用 自己处理
        h1.handleRequest();
        System.out.println("-------------------");
        //持有下一处理对象 交由下一对象处理
        h1.setNextHandler(h2);
        h1.handleRequest();
    }
}
