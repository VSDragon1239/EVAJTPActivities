package com.agp.template.presentation.views.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.agp.template.databinding.FragmentMainBinding;
import com.agp.template.presentation.viewmodels.universalfragments.MainViewModelFragment;
import com.agp.template.utils.Logger;

public class MainFragment extends Fragment {
    String TAG = "HomeFragment";

    public MainFragment() {
        Logger.log(TAG, "== initMainFragment ==");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        com.agp.template.databinding.FragmentMainBinding binding = FragmentMainBinding.inflate(inflater, container, false);
        MainViewModelFragment ufViewModel = new ViewModelProvider(requireActivity()).get(MainViewModelFragment.class);

        binding.setViewModel(ufViewModel);
        binding.setLifecycleOwner(this);

        return binding.getRoot();
    }
}