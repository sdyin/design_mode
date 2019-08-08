package com.sdyin.design.chainPattern;

/**
 * @Description
 * @Author liuye
 * @Date 2019/8/8 10:35
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleRequest() {
        if(getNextHandler() != null){
            System.out.println("交由下一对象" + getNextHandler() + " 处理");
            getNextHandler().handleRequest();
        }else{
            System.out.println("对象自身 " + this.toString() + " 处理");
        }
    }
}
