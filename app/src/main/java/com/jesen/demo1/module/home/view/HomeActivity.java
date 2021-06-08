package com.jesen.demo1.module.home.view;

import android.widget.Toast;

import androidx.databinding.ViewDataBinding;

import com.jesen.architecture.callback.LifecycleCallBack;
import com.jesen.architecture.ui.BaseActivity;
import com.jesen.demo1.R;
import com.jesen.demo1.databinding.ActivityHomeBinding;
import com.jesen.demo1.module.home.viewmodel.HomeViewModel;

public class HomeActivity extends BaseActivity {
    private final String TAG = HomeActivity.this.getClass().getSimpleName();
    ActivityHomeBinding binding;

    @Override
    protected int setLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected LifecycleCallBack setLifecycleCallBack() {
        return new LifecycleCallBack() {
            @Override
            public void update(String event) {
                Toast.makeText(HomeActivity.this, TAG + " " + event, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void initView(ViewDataBinding viewDataBinding) {
        binding = (ActivityHomeBinding) viewDataBinding;
    }
}
