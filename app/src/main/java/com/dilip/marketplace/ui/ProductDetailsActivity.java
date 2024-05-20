package com.dilip.marketplace.ui;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.ActivityProductDetailsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ProductDetailsActivity extends AppCompatActivity {

    ActivityProductDetailsBinding binding;
    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndicator;

    private ViewPager productDetailsViewPager;
    private TabLayout productDetailsTabLayout;

    private FloatingActionButton addToWishlistBtn;
    private boolean ALREADY_ADDED_TO_WISHLIST = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewPagerIndicator = findViewById(R.id.viewpager_indicator);
        addToWishlistBtn = findViewById(R.id.add_to_wishlist_btn);

        productDetailsTabLayout  = findViewById(R.id.product_details_tabLayout);
        productDetailsViewPager = findViewById(R.id.product_details_viewPager);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.iphone_13);
        productImages.add(R.drawable.galaxy_m34);
        productImages.add(R.drawable.iqoo_z6);
        productImages.add(R.drawable.realme_13c);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewPagerIndicator.setupWithViewPager(productImagesViewPager, true);

        addToWishlistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISHLIST) {
                    ALREADY_ADDED_TO_WISHLIST = false;
                    addToWishlistBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                } else {
                    ALREADY_ADDED_TO_WISHLIST = true;
                    addToWishlistBtn.setSupportImageTintList(getResources().getColorStateList(R.color.blue));
                }

            }
        });

        productDetailsViewPager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(), productDetailsTabLayout.getTabCount()));
        productDetailsViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTabLayout));

        productDetailsTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            // todo: search
            return true;
        } else if (id == R.id.action_search){

            return true;
        } else if (id == R.id.action_cart) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}