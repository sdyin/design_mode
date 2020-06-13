package com.sdyin.design.utils;

import org.springframework.util.Assert;
import sun.misc.Unsafe;
import org.junit.Test;
import java.lang.reflect.Field;

/**
 * @Description
 * @Author liuye
 * @Date 2020/6/11 9:51
 **/
public class UnsafeUtil {

    /**
     * 获取Unsafe类对象
     * @return
     * @throws Exception
     */
    private Unsafe getUnsafe() throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        return unsafe;
    }

    @Test
    public void getUnsafeTest(){
        UnsafeUtil unsafeUtil = new UnsafeUtil();
        Unsafe unsafe = null;
        try {
            unsafe = unsafeUtil.getUnsafe();
        } catch (Exception e) {
        }
        Assert.notNull(unsafe);
    }

}
