package com.dilip.marketplace.ui.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dilip.marketplace.R;
import com.dilip.marketplace.ui.product.ProductSpecificationAdapter;
import com.dilip.marketplace.ui.product.ProductSpecificationModel;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecificationFragment extends Fragment {



    public ProductSpecificationFragment() {
        // Required empty public constructor
    }

    private RecyclerView productSpecificationRecycleView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product_specification, container, false);

        productSpecificationRecycleView = view.findViewById(R.id.product_specification_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        productSpecificationRecycleView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"General"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM","12GB"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM","12GB"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM","12GB"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM","12GB"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM","12GB"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"RAM","12GB"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Display"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Resolution","1440p"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Resolution","1440p"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Resolution","1440p"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Resolution","1440p"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Resolution","1440p"));


        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecycleView.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();

        return view;
    }
}