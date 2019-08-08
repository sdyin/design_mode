package com.sdyin.design.chainPattern;

/**
 * 责任链模式:
 * 优点: 1.请求者和处理者解耦。2.提高系统灵活性
 * 缺点: 1.降低程序性能,请求链都是从头到尾 2.增加调试复杂度
 * @Description 抽象处理者
 * @Author liuye
 * @Date 2019/8/8 10:31
 */
public abstract class Handler {

    /**
     * 下一个处理器
     */
    private Handler nextHandler;

    /**
     * 处理方法
     */
    public abstract void handleRequest();

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
