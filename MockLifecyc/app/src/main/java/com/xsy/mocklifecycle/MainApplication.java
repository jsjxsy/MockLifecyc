package com.xsy.mocklifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.xsy.mocklifecycle.lifecycle.LifecycleCustom;
import com.xsy.mocklifecycle.lifecycle.LifecycleOwerCustom;
import com.xsy.mocklifecycle.reflect.LifeCycleObserverReflect;

/**
 * @author xiaosy
 * @create 2019-05-30
 * @Describe
 **/
public class MainApplication extends Application {

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

                }
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

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
