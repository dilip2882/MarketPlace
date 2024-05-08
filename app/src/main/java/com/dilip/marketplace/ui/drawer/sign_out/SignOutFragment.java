package com.dilip.marketplace.ui.drawer.sign_out;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dilip.marketplace.databinding.FragmentSignOutBinding;


public class SignOutFragment extends Fragment {

    public SignOutFragment() {
        // Required empty public constructor
    }

    FragmentSignOutBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignOutViewModel signOutViewModel =
                new ViewModelProvider(this).get(SignOutViewModel.class);
        // Inflate the layout for this fragment
        binding = FragmentSignOutBinding.inflate(getLayoutInflater());
        View root = binding.getRoot();

        final TextView textView = binding.textSignOut;
        signOutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }
}