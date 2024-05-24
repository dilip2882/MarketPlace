package com.dilip.marketplace.ui.wishlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dilip.marketplace.R;

import java.util.ArrayList;
import java.util.List;

public class MyWishlistFragment extends Fragment {


    public MyWishlistFragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistRecyclerview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);

        wishlistRecyclerview = view.findViewById(R.id.wishlist_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerview.setLayoutManager(layoutManager);

        List<WishlistModel> wishlistModelList = new ArrayList<>();
        wishlistModelList.add(new WishlistModel(R.drawable.iphone_13, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.galaxy_m34, "Iphone 13 (Black, 128 GB)", 0, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.realme_13c, "Iphone 13 (Black, 128 GB)", 4, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.oneplus_nord, "Iphone 13 (Black, 128 GB)", 2, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
        wishlistModelList.add(new WishlistModel(R.drawable.oneplus_11r, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));

        WishlistAdapter wishlistAdapter = new WishlistAdapter(wishlistModelList,true);
        wishlistRecyclerview.setAdapter(wishlistAdapter);
        wishlistAdapter.notifyDataSetChanged();


        return view;
    }
}