package com.dilip.marketplace.ui.drawer.marketplace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.FragmentMarketPlaceBinding;
import com.dilip.marketplace.ui.categories.HomeFragment;

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

//        setFragment(new HomeFragment());

        return root;
    }

/*    private void setFragment(Fragment fragment) {
        if (fragment == null) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//          fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
            fragmentTransaction.replace(binding.frameLayout.getId(), fragment);
            fragmentTransaction.commit();
        } else {
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }*/
}