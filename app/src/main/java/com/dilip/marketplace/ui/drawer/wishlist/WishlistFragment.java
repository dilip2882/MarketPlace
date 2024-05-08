package com.dilip.marketplace.ui.drawer.wishlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dilip.marketplace.databinding.FragmentWishlistBinding;


public class WishlistFragment extends Fragment {



    public WishlistFragment() {
        // Required empty public constructor
    }

    FragmentWishlistBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        WishlistViewModel wishlistViewModel =
                new ViewModelProvider(this).get(WishlistViewModel.class);
        // Inflate the layout for this fragment
        binding = FragmentWishlistBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        final TextView textView = binding.textWishlist;
        wishlistViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }
}