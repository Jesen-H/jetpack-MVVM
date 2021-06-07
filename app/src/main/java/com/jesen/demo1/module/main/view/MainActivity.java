package com.jesen.demo1.module.main.view;

import android.widget.Toast;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;

import com.jesen.architecture.callback.LifecycleCallBack;
import com.jesen.architecture.ui.BaseActivity;
import com.jesen.demo1.R;
import com.jesen.demo1.databinding.ActivityMainBinding;
import com.jesen.demo1.module.main.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.this.getClass().getSimpleName();
    ActivityMainBinding binding;
    MainViewModel viewModel;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected LifecycleCallBack setLifecycleCallBack() {
        return new LifecycleCallBack() {
            @Override
            public void update(String event) {
                Toast.makeText(MainActivity.this, TAG  + " " + event, Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void initView(ViewDataBinding viewDataBinding) {
        binding = (ActivityMainBinding) viewDataBinding;
        viewModel = new MainViewModel(this);
        binding.setViewModel(viewModel);
    }
}
