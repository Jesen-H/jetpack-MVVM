package com.jesen.architecture.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public abstract class BaseModel {

    private final MutableLiveData<Boolean> showLoadingData = new MutableLiveData<>();

    public LiveData<Boolean> loading() {
        return showLoadingData;
    }

    public void showLoading() {
        if (showLoadingData.getValue() == null || !showLoadingData.getValue())
            showLoadingData.setValue(true);
    }

    public void hideLoading() {
        if (showLoadingData.getValue() == null || showLoadingData.getValue())
            showLoadingData.setValue(false);
    }

//    {
//        showLoadingData.setValue(null);
//    }
}
