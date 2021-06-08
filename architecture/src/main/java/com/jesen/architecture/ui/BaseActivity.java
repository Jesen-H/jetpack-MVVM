package com.jesen.architecture.ui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jesen.architecture.BaseApplication;
import com.jesen.architecture.callback.LifecycleCallBack;
import com.jesen.architecture.observer.BaseLifecycleObserver;

public abstract class BaseActivity extends AppCompatActivity implements LifecycleOwner {

    private ViewModelProvider mActivityProvider;
    private ViewModelProvider mApplicationProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifecycleCallBack callBack = setLifecycleCallBack();
        if (callBack != null) {
            BaseLifecycleObserver observer = new BaseLifecycleObserver(callBack);
            getLifecycle().addObserver(observer);
        }

        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, setLayout());
        initView(viewDataBinding);
    }

    protected abstract int setLayout();

    protected LifecycleCallBack setLifecycleCallBack() {
        return null;
    }

    protected void initView(ViewDataBinding viewDataBinding) {

    }

    protected <T extends ViewModel> T getActivityScopeViewModel(Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    protected <T extends ViewModel> T getApplicationScopeViewModel(Class<T> modelClass) {
        if (mApplicationProvider == null) {
            mApplicationProvider = new ViewModelProvider((BaseApplication) this.getApplication(), getAppFactory(this));
        }
        return mActivityProvider.get(modelClass);
    }

    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application application = checkApplication(activity);
        return ViewModelProvider.AndroidViewModelFactory.getInstance(application);
    }

    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application == null) {
            throw new IllegalStateException("Your activity/fragment is not yet attached to "
                    + "Application. You can't request ViewModel before onCreate call.");
        }
        return application;
    }

    public void showLoading(String msg) {

    }

    public void hideLoading() {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
