package com.dilip.marketplace.ui.my_cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dilip.marketplace.R;
import com.dilip.marketplace.ui.my_cart.MyOrderAdapter;
import com.dilip.marketplace.ui.my_cart.MyOrderItemModel;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrdersRecyclerview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_orders, container, false);

        myOrdersRecyclerview = view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerview.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.iphone_13, 2, "Iphone 13 (Black, 128 GB)", "Delivered on Monday, 25th April 2024"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.galaxy_m34, 3, "Iphone 13 (Black, 128 GB)", "Delivered on Monday, 25th April 2024"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.realme_13c, 4, "Iphone 13 (Black, 128 GB)", "Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.iphone_13, 5, "Iphone 13 (Black, 128 GB)", "Delivered on Monday, 25th April 2024"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerview.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();

        return view;
    }
}