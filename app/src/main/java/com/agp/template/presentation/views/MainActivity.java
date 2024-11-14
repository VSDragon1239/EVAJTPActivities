package com.agp.template.presentation.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.agp.template.R;
import com.agp.template.databinding.ActivityMainBinding;
import com.agp.template.databinding.NavMenuBinding;
import com.agp.template.presentation.viewmodels.mainwindow.MainSharedViewModel;
import com.agp.template.presentation.viewmodels.mainwindow.MainViewModelActivity;
import com.agp.template.presentation.viewmodels.universalfragments.MainViewModelFragment;
import com.agp.template.presentation.views.fragments.MainFragment;
import com.agp.template.utils.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Подключение Layout и настройка отступов
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        com.agp.template.databinding.ActivityMainBinding viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        com.agp.template.databinding.NavMenuBinding navigationBinding = NavMenuBinding.bind(viewBinding.navigationMenu.getRoot());

        MainViewModelActivity viewModel = new ViewModelProvider(this).get(MainViewModelActivity.class);
        MainSharedViewModel sharedViewModel = new ViewModelProvider(this).get(MainSharedViewModel.class);
        MainViewModelFragment ufViewModel = new ViewModelProvider(this).get(MainViewModelFragment.class);

        viewModel.setSharedViewModel(sharedViewModel);
        sharedViewModel.setUfViewModel(ufViewModel);

        viewBinding.setViewModel(viewModel);
        viewBinding.setLifecycleOwner(this);

        String TAG = "onCreate";
        
        replaceFragment(new MainFragment());

        navigationBinding.navButton1.setOnClickListener(v -> replaceFragment(new MainFragment()));
        navigationBinding.navButton2.setOnClickListener(v -> Logger.log(TAG, "== click_navButton2 =="));
    }

    private void replaceFragment(Fragment fragment) {
        Logger.log("replaceFragment", "== click_navButton ==");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}