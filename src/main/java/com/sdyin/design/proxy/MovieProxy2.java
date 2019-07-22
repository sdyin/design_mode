package com.sdyin.design.proxy;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/21$ 上午10:28$
 */
public class MovieProxy2 implements Movie{

    private RealMovie realMovie;

    public MovieProxy2(RealMovie realMovie) {
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        drink();
        realMovie.play();
        eat();
    }

    private void eat() {
        System.out.println("要去吃饭吗？");
    }

    private void drink() {
        System.out.println("要来点饮料吗?");
    }
}
