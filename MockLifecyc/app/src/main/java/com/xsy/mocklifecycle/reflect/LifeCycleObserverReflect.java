package com.xsy.mocklifecycle.reflect;

import com.xsy.mocklifecycle.annotation.Lifecyce;
import com.xsy.mocklifecycle.lifecycle.LifecycleCustom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xiaosy
 * @create 2019-05-30
 * @Describe
 **/
public class LifeCycleObserverReflect {
    public static void test(LifecycleCustom observer, String item) {
        invokeMethod(observer, item);
    }


    public static void invokeMethod(LifecycleCustom observer, String item) {
        Class<?> clazz = observer.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Lifecyce lifecyce = method.getAnnotation(Lifecyce.class);
            //获取方法上@ApiOperation注解的value值
            String type = lifecyce.value();
            if (type.equals(item)) {
                try {
                    method.invoke(observer);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
