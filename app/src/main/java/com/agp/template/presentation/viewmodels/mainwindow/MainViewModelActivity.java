package com.agp.template.presentation.viewmodels.mainwindow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agp.template.utils.Logger;

public class MainViewModelActivity extends ViewModel {
    String lastActBtnId = "";
    String TAG = "MainViewModelActivity";

    public MainViewModelActivity() {
        Logger.log(TAG, "== initMainViewModelActivity ==");
    }


    private MainSharedViewModel sharedViewModel;

    private final MutableLiveData<String> text = new MutableLiveData<>("Изначальный текст при запуске.com");
    private final MutableLiveData<String> btn1Text = new MutableLiveData<>("Название Кнопки 1");


    public void setSharedViewModel(MainSharedViewModel mainSharedViewModel) {
        this.sharedViewModel = mainSharedViewModel;
    }


    public void onButtonClick1() {
        lastActBtnId = "1";
        Logger.log(TAG, "== init_onButtonClick1' ==");

        String oBS = "Текст сверху в TextView - 1 кнопка активировала";
        text.setValue(oBS);
    }

    public void onButtonClick2() {
        lastActBtnId = "1";
        Logger.log(TAG, "== init_onButtonClick2' ==");
        String oBS = "HelloWorld! Активировано кнопкой 2";
        text.setValue(oBS);
        sharedViewModel.updateUfViewModelDataFromMainViewModelActivity("Привет из главного ViewModel в фрагмент!");
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
