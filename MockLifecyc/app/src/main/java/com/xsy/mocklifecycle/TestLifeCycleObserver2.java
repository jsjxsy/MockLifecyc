package com.xsy.mocklifecycle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.xsy.annotation.lifecycle.LifecycleCustom;


/**
 * @author xiaosy
 * @create 2019-06-05
 * @Describe
 **/
public class TestLifeCycleObserver2 implements Handler.Callback {
    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case LifecycleCustom
                    .ON_CREATE_MESSAGE:
                Log.e("xsy","onCreate()");
                break;
        }
        return false;
    }
}
