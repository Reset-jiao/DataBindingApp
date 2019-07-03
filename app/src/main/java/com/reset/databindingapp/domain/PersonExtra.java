package com.reset.databindingapp.domain;

import androidx.databinding.ObservableField;

// 不再继承BaseObservable
public class PersonExtra {

    // 使用ObservableField作为字段类型
    public ObservableField<String> address = new ObservableField<>();

}
