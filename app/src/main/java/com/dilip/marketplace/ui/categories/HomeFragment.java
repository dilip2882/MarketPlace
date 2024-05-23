package com.dilip.marketplace.ui.categories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.FragmentHomeBinding;
import com.dilip.marketplace.ui.OrderDetailsActivity;
import com.dilip.marketplace.ui.home.HomePageAdapter;
import com.dilip.marketplace.ui.home.HomePageModel;
import com.dilip.marketplace.ui.horizontal_product_view.HorizontalProductScrollModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        binding.categoryRecyclerview.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Mobiles"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Toys"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Arts"));
        categoryModelList.add(new CategoryModel("link","Books"));
        categoryModelList.add(new CategoryModel("link","Shoes"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryModelList);
        binding.categoryRecyclerview.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        ///////// Banner Slider
        List<OrderDetailsActivity.SliderModel> sliderModelList = new ArrayList<>();
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner5,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner6,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner1,"#ffffff"));

        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner2,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner3,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner4,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner5,"#ffffff"));

        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner6,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner1,"#ffffff"));
        sliderModelList.add(new OrderDetailsActivity.SliderModel(R.drawable.banner2,"#ffffff"));
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

        LinearLayoutManager testingLinearLayoutManager = new LinearLayoutManager(getContext());
        testingLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.homePageRecyclerview.setLayoutManager(testingLinearLayoutManager);

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,R.drawable.banner0,"#ffffff"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(3, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(2, "Deals of the day", horizontalProductScrollModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner1,"#ffffff"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        binding.homePageRecyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ///////


        return root;
    }
    ///////// Banner Slider

    ///////// Banner Slider

}