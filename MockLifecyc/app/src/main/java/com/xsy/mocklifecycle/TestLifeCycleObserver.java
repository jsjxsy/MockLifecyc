package com.xsy.mocklifecycle;

import android.util.Log;

import com.xsy.annotation.Lifecyce;
import com.xsy.annotation.lifecycle.LifecycleCustom;


/**
 * @author xiaosy
 * @create 2019-05-30
 * @Describe
 **/
public class TestLifeCycleObserver implements LifecycleCustom {

    @Lifecyce(LifecycleCustom.ON_CREATE)
    public void test1() {
        Log.e("xsy","test1");
    }


    @Lifecyce(LifecycleCustom.ON_RESUME)
    public void test2() {
        Log.e("xsy","test2");
    }


    @Lifecyce(LifecycleCustom.ON_STOP)
    public void test3() {
        Log.e("xsy","test3");
    }
}
