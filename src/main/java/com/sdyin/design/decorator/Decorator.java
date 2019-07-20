package com.sdyin.design.decorator;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/20$ 下午9:44$
 */
public abstract class Decorator implements Human {

    private Human human;

    public Decorator(Human human) {
        this.human = human;
    }

    @Override
    public void eat(){
        human.eat();
    }

    @Override
    public void wearClothes() {
        human.wearClothes();
    }
}
