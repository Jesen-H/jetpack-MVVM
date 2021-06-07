package com.jesen.architecture.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.jesen.architecture.callback.LifecycleCallBack;

public class BaseLifecycleObserver implements LifecycleObserver {
    private LifecycleCallBack callBack;

    public BaseLifecycleObserver(LifecycleCallBack callBack) {
        this.callBack = callBack;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        if (callBack != null) {
            callBack.update("Lifecycle.Event.ON_CREATE");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        if (callBack != null) {
            callBack.update("Lifecycle.Event.ON_START");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (callBack != null) {
            callBack.update("Lifecycle.Event.ON_RESUME");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        if (callBack != null) {
            callBack.update("Lifecycle.Event.ON_PAUSE");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        if (callBack != null) {
            callBack.update("Lifecycle.Event.ON_STOP");
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        // 事件触发都会执行该方法
    }
}
