package com.jesen.demo1.module.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.jesen.demo1.BR;

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
    }

    public MainViewModel(Context mContext) {
        this.mContext = mContext;
    }
}
