package com.sdyin.design.decorator;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/20$ 下午10:14$
 */
public class DecoratorImplC extends Decorator{

    public DecoratorImplC(Human human) {
        super(human);
    }

    @Override
    public void eat() {
        super.eat();
        getFruit();
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        nice();
    }

    public void getFruit(){
        System.out.println("再来点水果吧");
    }

    public void nice(){
        System.out.println("这件衣服真好看");
    }
}
