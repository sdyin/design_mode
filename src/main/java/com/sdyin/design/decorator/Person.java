package com.sdyin.design.decorator;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/20$ 下午10:10$
 */
public class Person implements Human{
    @Override
    public void eat() {
        System.out.println("准备吃东西啦");
    }

    @Override
    public void wearClothes() {
        System.out.println("准备穿衣服出门啦");
    }
}
