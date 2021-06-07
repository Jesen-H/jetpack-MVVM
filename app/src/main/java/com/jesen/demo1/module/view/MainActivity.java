package com.jesen.demo1.module.view;

import androidx.databinding.ViewDataBinding;

import com.jesen.demo1.R;
import com.jesen.demo1.base.BaseActivity;
import com.jesen.demo1.databinding.ActivityMainBinding;
import com.jesen.demo1.module.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    MainViewModel viewModel;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(ViewDataBinding viewDataBinding) {
        binding = (ActivityMainBinding) viewDataBinding;
        viewModel = new MainViewModel(this);
        binding.setViewModel(viewModel);
    }
}
