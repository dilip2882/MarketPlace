package com.dilip.marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.appcompat.app.AppCompatActivity;

import com.dilip.marketplace.databinding.ActivitySplashBinding;


public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SystemClock.sleep(3000);
        startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
        finish();
    }
}