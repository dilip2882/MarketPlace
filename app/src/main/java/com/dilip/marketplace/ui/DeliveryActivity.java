package com.dilip.marketplace.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.ActivityDeliveryBinding;
import com.dilip.marketplace.ui.address.MyAddressesActivity;
import com.dilip.marketplace.ui.cart.CartAdapter;
import com.dilip.marketplace.ui.cart.CartItemModel;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    private ActivityDeliveryBinding binding;
    private RecyclerView deliveryRecyclerview;
    private Button changeOrAddNewAddressBtn;
    public static final int SELECT_ADDRESS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deliveryRecyclerview = findViewById(R.id.delivery_recyclerview);
        changeOrAddNewAddressBtn = findViewById(R.id.change_or_add_address_btn);
//        continueBtn = view.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        deliveryRecyclerview.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0, R.drawable.iphone_13,"Iphone 13 (Black, 128 GB)", 2, "Rs.99,999/-", "Rs.99,999/-",1,0,0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.iphone_13,"Iphone 13 (Black, 128 GB)", 0, "Rs.99,999/-", "Rs.99,999/-",1,1,0));
        cartItemModelList.add(new CartItemModel(0, R.drawable.iphone_13,"Iphone 13 (Black, 128 GB)", 2, "Rs.99,999/-", "Rs.99,999/-",1,2,0));

        cartItemModelList.add(new CartItemModel(1, "Price (3 items)", "Rs.3,99,999/-", "free", "Rs.3,99,999/-", "Rs.1,99,999/-"));

        CartAdapter cartAdapter= new CartAdapter(cartItemModelList);
        deliveryRecyclerview.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeOrAddNewAddressBtn.setVisibility(View.VISIBLE);
        changeOrAddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent = new Intent(DeliveryActivity.this, MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}