package com.dilip.marketplace.ui.drawer.cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dilip.marketplace.databinding.FragmentCartBinding;

public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }



    FragmentCartBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CartViewModel cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        final TextView textView = binding.textCart;
        cartViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }
}