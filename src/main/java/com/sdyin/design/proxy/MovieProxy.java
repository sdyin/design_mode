package com.sdyin.design.proxy;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/21$ 上午10:22$
 */
public class MovieProxy implements Movie{

    private RealMovie realMovie;

    public MovieProxy(RealMovie realMovie) {
        this.realMovie = realMovie;
    }

    @Override
    public void play() {
        dothings();
        realMovie.play();
        good();
    }

    private void good() {
        System.out.println("嗯 不错不错，nice");
    }

    private void dothings() {
        System.out.println("把空调开大点，再大点");
    }
}
