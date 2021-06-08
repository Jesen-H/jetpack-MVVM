package com.jesen.demo1.module.main.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * 接口处理
 */
public class MainModel {

    private final MutableLiveData<String> valLiveData = new MutableLiveData<>();

    public LiveData<String> getValLiveData() {
        return valLiveData;
    }

    public void requestCount() {
        valLiveData.setValue("5");
    }
}
