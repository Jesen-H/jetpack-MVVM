package com.jesen.demo1.module.main.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.jesen.demo1.BR;
import com.jesen.demo1.module.home.view.HomeActivity;

public class MainViewModel extends BaseObservable {
    private Context mContext;
    private String count;

    @Bindable
    public String getCount() {
        if (count == null) {
            count = "0";
            return count;
        }
        return count;
    }

    public void setCount() {
        int mCount = Integer.parseInt(count);
        count = ++mCount + "";
        // 通知属性改变
        notifyPropertyChanged(BR.count);
        if (mCount > 5) {
            mContext.startActivity(new Intent(mContext, HomeActivity.class));
        }
    }

    public MainViewModel(Context mContext) {
        this.mContext = mContext;
    }
}
