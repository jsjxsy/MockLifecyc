package com.xsy.mocklifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

import com.xsy.annotation.lifecycle.LifecycleCustom;
import com.xsy.annotation.lifecycle.LifecycleOwerCustom;
import com.xsy.mocklifecycle.reflect.LifeCycleObserverReflect;

/**
 * @author xiaosy
 * @create 2019-05-30
 * @Describe
 **/
public class MainApplication extends Application {

    Handler handler = new Handler();
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                    if(activity instanceof LifecycleOwerCustom){
                        LifecycleCustom lifecycleCustom = ((LifecycleOwerCustom)activity).get();
                        if(lifecycleCustom != null){
                            LifeCycleObserverReflect.test(lifecycleCustom, LifecycleCustom.ON_CREATE);
                        }
                        handler.sendEmptyMessage(LifecycleCustom.ON_CREATE_MESSAGE);
                    }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                if(activity instanceof LifecycleOwerCustom){
                    LifecycleCustom lifecycleCustom = ((LifecycleOwerCustom)activity).get();
                    if(lifecycleCustom != null){
                        LifeCycleObserverReflect.test(lifecycleCustom,LifecycleCustom.ON_RESUME);
                    }

                    handler.sendEmptyMessage(LifecycleCustom.ON_RESUME_MESSAGE);
                }
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                handler.sendEmptyMessage(LifecycleCustom.ON_STOP_MESSAGE);
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
