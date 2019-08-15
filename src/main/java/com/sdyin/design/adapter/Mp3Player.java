package com.sdyin.design.adapter;

/**
 * @Description
 * @Author liuye
 * @Date 2019/8/15 18:01
 */
public class Mp3Player implements AudioPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("播放MP3,fileName:" + fileName);
    }
}
