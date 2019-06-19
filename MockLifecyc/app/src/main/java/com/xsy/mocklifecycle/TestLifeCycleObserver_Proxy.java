package com.xsy.mocklifecycle;

import com.xsy.annotation.lifecycle.LifecycleCustom;

/**
 * @author xiaosy
 * @create 2019-06-10
 * @Describe
 **/
public class TestLifeCycleObserver_Proxy {
    private TestLifeCycleObserver observer;
    public TestLifeCycleObserver_Proxy(TestLifeCycleObserver observer){
        observer = observer;
    }



    public void callMethods(String event){
        if(event == LifecycleCustom.ON_CREATE){
            observer.test1();
        }
    }

}
