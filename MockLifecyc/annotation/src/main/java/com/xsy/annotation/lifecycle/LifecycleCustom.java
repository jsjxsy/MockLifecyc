package com.xsy.annotation.lifecycle;

/**
 * @author xiaosy
 * @create 2019-05-30
 * @Describe
 **/
public interface LifecycleCustom {
    public static final String ON_CREATE = "onCreate()";
    public static final String ON_RESUME = "onResume()";
    public static final String ON_STOP = "onStop()";


    public static final int ON_CREATE_MESSAGE = 1;
    public static final int ON_RESUME_MESSAGE = 2;
    public static final int ON_STOP_MESSAGE = 3;
}
