package com.sdyin.design.adapter;

/**
 * 优点: 1、可以让任何两个没有关联的类一起运行。 2、提高了类的复用。 3、增加了类的透明度。 4、灵活性好。
 * 缺点:  1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。2.由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。
 * @Description 适配器模式
 * @Author liuye
 * @Date 2019/8/15 17:50
 */
public interface AudioPlayer {
    void play(String audioType);
}
