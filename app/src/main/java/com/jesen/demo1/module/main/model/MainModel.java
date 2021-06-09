package com.jesen.demo1.module.main.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jesen.architecture.model.BaseModel;

/**
 * 接口处理
 */
public class MainModel extends BaseModel {

    private final MutableLiveData<String> valLiveData = new MutableLiveData<>();

    public LiveData<String> value() {
        return valLiveData;
    }

    public void requestCount(String count) {
        int val = Integer.parseInt(count);
        valLiveData.setValue(++val + "");
    }
}
