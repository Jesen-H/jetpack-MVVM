package com.jesen.demo1.module.main.view;

import android.widget.Toast;

import androidx.databinding.ViewDataBinding;

import com.jesen.architecture.callback.LifecycleCallBack;
import com.jesen.architecture.ui.BaseActivity;
import com.jesen.demo1.R;
import com.jesen.demo1.databinding.ActivityMainBinding;
import com.jesen.demo1.module.main.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.this.getClass().getSimpleName();
    private MainViewModel viewModel;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected LifecycleCallBack setLifecycleCallBack() {
        return event -> Toast.makeText(MainActivity.this, TAG + " " + event, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView(ViewDataBinding viewDataBinding) {
        ActivityMainBinding binding = (ActivityMainBinding) viewDataBinding;
        viewModel = getActivityScopeViewModel(MainViewModel.class);
        binding.setViewModel(viewModel);
        binding.setClick(new ClickProxy());
        viewModel.model.getValLiveData().observe(this, s -> viewModel.count.set(s));
    }

    public class ClickProxy {

        public void addClick() {
            viewModel.model.requestCount(viewModel.count.get());
        }
    }
}
