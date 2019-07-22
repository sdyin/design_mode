package com.sdyin.design.proxy;

/**
 * 测试代理模式
 * 代码：代理类构造器 注入真实对象，真实对象处理逻辑。只做前置 后置处，控制对象访问权
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
