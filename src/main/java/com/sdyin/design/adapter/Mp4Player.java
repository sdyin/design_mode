package com.sdyin.design.adapter;

/**
 * @Description
 * @Author liuye
 * @Date 2019/8/15 17:53
 */
public class Mp4Player implements VideoPlayer {

    @Override
    public void playMp4(String fileName) {
        System.out.println("播放MP4,fileName:" + fileName);
    }
}
