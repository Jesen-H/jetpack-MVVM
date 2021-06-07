package com.jesen.architecture.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

import com.jesen.architecture.callback.LifecycleCallBack;
import com.jesen.architecture.observer.BaseLifecycleObserver;

public abstract class BaseActivity extends AppCompatActivity implements LifecycleOwner {
    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleRegistry = new LifecycleRegistry(this);

        LifecycleCallBack callBack = setLifecycleCallBack();
        if (callBack != null) {
            BaseLifecycleObserver observer = new BaseLifecycleObserver(callBack);
            lifecycleRegistry.addObserver(observer);
        }
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);

        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, setLayout());
        initView(viewDataBinding);
    }

    protected abstract int setLayout();

    protected LifecycleCallBack setLifecycleCallBack() {
        return null;
    }

    protected void initView(ViewDataBinding viewDataBinding) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        lifecycleRegistry.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleRegistry.setCurrentState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }
}
