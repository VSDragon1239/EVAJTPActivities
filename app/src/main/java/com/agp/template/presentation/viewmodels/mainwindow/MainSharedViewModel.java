package com.agp.template.presentation.viewmodels.mainwindow;

import androidx.lifecycle.ViewModel;

import com.agp.template.presentation.viewmodels.universalfragments.MainViewModelFragment;
import com.agp.template.utils.Logger;

public class MainSharedViewModel extends ViewModel {
    String lastActBtnId = "";
    String TAG = "MainSharedViewModel";

    private MainViewModelFragment ufViewModel;

    public MainSharedViewModel() {
        Logger.log(TAG, "== MainSharedViewModel ==");
    }

    public void setUfViewModel(MainViewModelFragment ufViewModel) {
        Logger.log(TAG, "== setUfViewModel ==");
        this.ufViewModel = ufViewModel;
    }

    public void updateUfViewModelDataFromMainViewModelActivity(String data) {
        ufViewModel.updateTextData(data);
    }
}
