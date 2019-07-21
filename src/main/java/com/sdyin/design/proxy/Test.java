package com.sdyin.design.proxy;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/21$ 上午10:25$
 */
public class Test {

    public static void main(String[] args) {

        RealMovie realMovie = new RealMovie();
        MovieProxy movieProxy = new MovieProxy(realMovie);
        movieProxy.play();
        System.out.println("---------------");
        new MovieProxy2(realMovie).play();
    }
}
