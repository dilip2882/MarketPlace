package com.dilip.marketplace.ui.drawer.rewards;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dilip.marketplace.databinding.FragmentRewardsBinding;


public class RewardsFragment extends Fragment {


    public RewardsFragment() {
        // Required empty public constructor
    }

    FragmentRewardsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RewardsViewModel rewardsViewModel =
                new ViewModelProvider(this).get(RewardsViewModel.class);
        // Inflate the layout for this fragment
        binding = FragmentRewardsBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        final TextView textView = binding.textRewards;
        rewardsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }
}