package com.dilip.marketplace.ui.categories;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.ActivityCategoryBinding;
import com.dilip.marketplace.ui.home.HomePageAdapter;
import com.dilip.marketplace.ui.home.HomePageModel;
import com.dilip.marketplace.ui.horizontal_product_view.HorizontalProductScrollModel;
import com.dilip.marketplace.ui.slider.SliderModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    ActivityCategoryBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        String title = getIntent().getStringExtra("categoryName");
        getSupportActionBar().setTitle(title);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ///////// Banner Slider
        List<SliderModel> sliderModelList = new ArrayList<>();
        sliderModelList.add(new SliderModel(R.drawable.banner5,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner6,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner1,"#ffffff"));

        sliderModelList.add(new SliderModel(R.drawable.banner2,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner3,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner4,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner5,"#ffffff"));

        sliderModelList.add(new SliderModel(R.drawable.banner6,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner1,"#ffffff"));
        sliderModelList.add(new SliderModel(R.drawable.banner2,"#ffffff"));
        ///////// Banner Slider

        ///////// Strip Ad
        ///////// Strip Ad

        //////// Horizontal Product Layout


        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iqoo_z6,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_nord,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_11r,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.galaxy_m34,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        //////// Horizontal Product Layout

        //////// Grid Product Layout

        //////// Grid Product Layout

        ////////

        LinearLayoutManager testingLinearLayoutManager = new LinearLayoutManager(this);
        testingLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.categoryRecyclerView.setLayoutManager(testingLinearLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,R.drawable.banner0,"#ffffff"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner0,"#ffffff"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        binding.categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ///////


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            // todo: search
            return true;
        } else if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}