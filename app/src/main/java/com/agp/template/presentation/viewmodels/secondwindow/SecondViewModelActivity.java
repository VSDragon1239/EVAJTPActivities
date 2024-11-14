package com.agp.template.presentation.viewmodels.secondwindow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agp.template.utils.Logger;

public class SecondViewModelActivity extends ViewModel {
    String lastActBtnId = "";
    String TAG = "SecondViewModelActivity";

    public SecondViewModelActivity() {
        Logger.log(TAG, "== initSecondViewModelActivity ==");
    }


    private final MutableLiveData<String> text = new MutableLiveData<>("Изначальный текст при запуске.com в окне 2");
    private final MutableLiveData<String> btn1Text = new MutableLiveData<>("Название Кнопки 1 в окне 2");


    public void onButtonClick1() {
        lastActBtnId = "1";
        Logger.log(TAG, "== init_onButtonClick1' ==");

        String oBS = "Текст сверху в TextView - 1 кнопка активировала в окне 2";
        text.setValue(oBS);
    }

    public LiveData<String> getText() {
        Logger.log(TAG, "== LiveData_getText ==");

        return text;
    }

    public LiveData<String> getBtn1Text() {
        Logger.log(TAG, "== LiveData_getBtn1Text ==");

        return btn1Text;
    }
}
