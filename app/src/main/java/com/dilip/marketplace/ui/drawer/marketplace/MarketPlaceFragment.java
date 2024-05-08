package com.dilip.marketplace.ui.drawer.marketplace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dilip.marketplace.databinding.FragmentMarketPlaceBinding;

public class MarketPlaceFragment extends Fragment {



    public MarketPlaceFragment() {
        // Required empty public constructor
    }

FragmentMarketPlaceBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MarketPlaceViewModel homeViewModel = new ViewModelProvider(this).get(MarketPlaceViewModel.class);

        // Inflate the layout for this fragment
        binding = FragmentMarketPlaceBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        final TextView textView = binding.textMarketPlace;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}