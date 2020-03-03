package com.sdyin.design.decorator;

/**
 * 测试装饰者模式
 * 装饰者构造器 都注入接口功能 -》 逐步增强扩展
 * 采用装饰模式，一旦你觉得需要增加一个功能，那你只需要将现有的类作为参数传入到构造函数就行
 * @Description:
 * @Author: liuye
 * @time: 2019/7/20$ 下午10:18$
 */
public class Test {

    public static void main(String[] args) {
        Human person = new Person();
        DecoratorImplC decorator = new DecoratorImplC(new DecoratorImplB(new DecoratorImpA(person)));
        decorator.eat();
        decorator.wearClothes();
    }
}
