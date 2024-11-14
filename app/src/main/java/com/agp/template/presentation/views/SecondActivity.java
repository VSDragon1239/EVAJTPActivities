package com.agp.template.presentation.views;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.agp.template.R;
import com.agp.template.databinding.ActivitySecondBinding;
import com.agp.template.databinding.NavMenuBinding;
import com.agp.template.presentation.viewmodels.secondwindow.SecondViewModelActivity;
import com.agp.template.utils.Logger;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Подключение Layout и настройка отступов
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        com.agp.template.databinding.ActivitySecondBinding viewBinding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        com.agp.template.databinding.NavMenuBinding navigationBinding = NavMenuBinding.bind(viewBinding.navigationMenu.getRoot());

        SecondViewModelActivity secondViewModelActivity = new ViewModelProvider(this).get(SecondViewModelActivity.class);

        viewBinding.setSecondViewModel(secondViewModelActivity);
        viewBinding.setLifecycleOwner(this);

        String TAG = "onCreate";
        navigationBinding.navButton1.setOnClickListener(v -> Logger.log(TAG, "== click_navButton1 в окне 2 =="));
        navigationBinding.navButton2.setOnClickListener(v -> Logger.log(TAG, "== click_navButton2 в окне 2=="));
    }
}