package com.dilip.marketplace.ui.categories;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.FragmentHomeBinding;
import com.dilip.marketplace.databinding.HorizontalScrollLayoutBinding;
import com.dilip.marketplace.databinding.SlidingAdLayoutBinding;
import com.dilip.marketplace.databinding.StripAdLayoutBinding;
import com.dilip.marketplace.ui.product_scroll.HorizontalProductScrollAdapter;
import com.dilip.marketplace.ui.product_scroll.HorizontalProductScrollModel;
import com.dilip.marketplace.ui.slider.SliderAdapter;
import com.dilip.marketplace.ui.slider.SliderModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    FragmentHomeBinding binding;
    ///////// Banner Slider
    SlidingAdLayoutBinding includedSlidingAdView;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    private final long DELAY_TIME = 2000;
    private final long PERIOD_TIME = 2000;
    //////// Banner Slider

    //////// Horizontal Product Layout
    /*private TextView horizontalLayoutTitle;
    private Button viewAllBtn;
    private RecyclerView HorizontalRecyclerView;*/
    HorizontalScrollLayoutBinding includedHorizontalLayoutBinding;

    //////// Horizontal Product Layout


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        // Access included layout view
        includedSlidingAdView = binding.includedSlidingAdView;
        // Access views within included_layout.xml using includedBinding
        ViewPager bannerSliderViewPager = includedSlidingAdView.bannerSliderViewPager;


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
        sliderModelList = new ArrayList<>();
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

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);
        bannerSliderViewPager.setCurrentItem(currentPage);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    pageLooper();
                }
            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    startBannerSlideShow();
                }
                return false;
            }
        });

        bannerSliderViewPager.setAdapter(sliderAdapter);
        sliderAdapter.notifyDataSetChanged();
        ///////// Banner Slider

        ///////// Strip Ad
        // Access included layout view
        StripAdLayoutBinding includedStripAdView = binding.includedStripAdView;
        // Access views within included_layout.xml using includedBinding
        ImageView stripAdImage = includedStripAdView.stripAdImage;
        ConstraintLayout stripAdContainer = includedStripAdView.stripAdContainer;

       /* stripAdImage.setImageResource(R.drawable.baseline_store_mall_directory_24);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));*/
        ///////// Strip Ad

        //////// Horizontal Product Layout
        includedHorizontalLayoutBinding = binding.includedHorizontalScrollView;
        TextView horizontalLayoutTitle = includedHorizontalLayoutBinding.horizontalScrollLayoutTitle;
        Button horizontalLayoutViewAllBtn = includedHorizontalLayoutBinding.horizontalScrollLayoutViewAllButton;
        RecyclerView horizontalLayoutRecyclerview = includedHorizontalLayoutBinding.horizontalScrollLayoutRecyclerview;

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iqoo_z6,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_nord,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_11r,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalLayoutRecyclerview.setLayoutManager(linearLayoutManager);
        horizontalLayoutRecyclerview.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();
        //////// Horizontal Product Layout



        return root;
    }
    ///////// Banner Slider
    private void pageLooper() {
        if (currentPage == sliderModelList.size()-2) {
            currentPage = 2;
            includedSlidingAdView.bannerSliderViewPager.setCurrentItem(currentPage,true);
        }
        if (currentPage == 1) {
            currentPage = sliderModelList.size() - 3;
            includedSlidingAdView.bannerSliderViewPager.setCurrentItem(currentPage,true);
        }
    }

    private void startBannerSlideShow() {
        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()) {
                    currentPage = 1;
                }
                includedSlidingAdView.bannerSliderViewPager.setCurrentItem(currentPage++, true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_TIME, PERIOD_TIME);

    }

    private void stopBannerSlideShow() {
        timer.cancel();
    }
    ///////// Banner Slider

}