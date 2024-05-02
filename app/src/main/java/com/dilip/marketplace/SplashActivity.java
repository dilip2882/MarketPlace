package com.dilip.marketplace;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dilip.marketplace.databinding.ActivitySplashBinding;


public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}