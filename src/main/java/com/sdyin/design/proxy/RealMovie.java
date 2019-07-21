package com.sdyin.design.proxy;

/**
 * @Description:
 * @Author: liuye
 * @time: 2019/7/21$ 上午10:21$
 */
public class RealMovie implements Movie{

    @Override
    public void play() {
        System.out.println("观看电影，肖申克的救赎");
    }
}
