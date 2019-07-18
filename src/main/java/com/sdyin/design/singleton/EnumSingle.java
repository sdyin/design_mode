package com.sdyin.design.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 枚举实现单例
 * @Description
 * @Author liuye
 * @Date 2019/7/18 21:18
 */
public enum EnumSingle {

    /**
     * 实例
     */
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) throws InterruptedException {
        // 单例测试
        EnumSingle firstSingleton = EnumSingle.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        EnumSingle secondSingleton = EnumSingle.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());
    }
}
