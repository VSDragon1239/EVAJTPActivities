package com.agp.template.presentation.viewmodels.universalfragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agp.template.utils.Logger;

public class MainViewModelFragment extends ViewModel {
    String TAG = "MainViewModelFragment";

    public MainViewModelFragment() {
        Logger.log(TAG, "== initMainViewModelFragment ==");
    }

    private final MutableLiveData<String> TextData = new MutableLiveData<>("Изначальный текст в Фрагменте - Main");

    public LiveData<String> getTextData() {
        return TextData;
    }

    public void updateTextData(String data) {
        TextData.setValue(data);
    }
}
