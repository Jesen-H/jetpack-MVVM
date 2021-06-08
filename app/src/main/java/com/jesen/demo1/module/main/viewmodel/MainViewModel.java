package com.jesen.demo1.module.main.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.jesen.demo1.module.main.model.MainModel;

public class MainViewModel extends ViewModel {

    public final ObservableField<String> count = new ObservableField<>();

    public final MainModel model = new MainModel();

    {
        count.set("0");
    }
}
