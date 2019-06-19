package com.xsy.mocklifecycle;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.xsy.annotation.lifecycle.LifecycleCustom;
import com.xsy.annotation.lifecycle.LifecycleOwerCustom;


public class MainActivity extends AppCompatActivity implements LifecycleOwerCustom {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public LifecycleCustom get() {
        return new TestLifeCycleObserver();
    }
}
