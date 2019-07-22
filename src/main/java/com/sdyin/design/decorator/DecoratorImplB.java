package com.sdyin.design.decorator;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/20$ 下午10:01$
 */
public class DecoratorImplB extends Decorator{

    public DecoratorImplB(Human human) {
        super(human);
    }

    @Override
    public void eat() {
        super.eat();
        getSweet();
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        buyClothes();
    }


    public void getSweet(){
        System.out.println("再来点甜点");
    }

    public void buyClothes(){
        System.out.println("去买点衣服吧");
    }
}
