package com.sdyin.design.decorator;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/20$ 下午9:54$
 */
public class DecoratorImpA extends Decorator{

    public DecoratorImpA(Human human) {
        super(human);
    }

    @Override
    public void eat() {
        super.eat();
        drink();
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findNoClothes();
    }

    public void drink(){
        System.out.println("再喝杯可口可乐");
    }

    public void findNoClothes(){
        System.out.println("发现没有适合的衣服了");
    }
}
