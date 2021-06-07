package com.jesen.demo1.module.home.viewmodel;

import android.app.Activity;

import androidx.databinding.BaseObservable;

public class FinishClick extends BaseObservable {
    private Activity mActivity;

    public FinishClick(Activity activity) {
        mActivity = activity;
    }

    public void setFinish() {
        mActivity.finish();
    }
}
