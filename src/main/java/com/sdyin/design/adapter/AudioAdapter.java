package com.sdyin.design.adapter;

/**
 * @Description 适配器类
 * @Author liuye
 * @Date 2019/8/15 17:54
 */
public class AudioAdapter implements AudioPlayer {

    VideoPlayer videoPlayer;

    AudioPlayer audioPlayer;

    public AudioAdapter(String audioType) {
        if("mp3".equalsIgnoreCase(audioType)){
            audioPlayer = new Mp3Player();
        }
        if("mp4".equalsIgnoreCase(audioType)){
            videoPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String fileName) {
        if("mp3".equalsIgnoreCase(fileName)){
            audioPlayer.play(fileName);
        }
        if("mp4".equalsIgnoreCase(fileName)){
            videoPlayer.playMp4(fileName);
        }
    }

    public static void main(String[] args) {
        AudioAdapter mp3 = new AudioAdapter("mp3");
        mp3.play("mp3");
        AudioAdapter mp4 = new AudioAdapter("mp4");
        mp4.play("mp4");
    }

}
