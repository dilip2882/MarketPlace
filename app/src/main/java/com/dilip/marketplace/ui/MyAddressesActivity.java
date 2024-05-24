package com.dilip.marketplace.ui;

import static com.dilip.marketplace.ui.DeliveryActivity.SELECT_ADDRESS;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.ActivityMyAddressesBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAddressesActivity extends AppCompatActivity {

    ActivityMyAddressesBinding binding;
    private RecyclerView myAddressesRecyclerview;
    private Button deliverHereBtn;
    private static AddressesAdapter addressesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAddressesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myAddressesRecyclerview = binding.addressesRecyclerview;
        deliverHereBtn = binding.deliverHereBtn;

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Addresses");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        myAddressesRecyclerview.setLayoutManager(layoutManager);

        List<AddressesModel> addressesModelList = new ArrayList<>();
        addressesModelList.add(new AddressesModel("Dilip Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",true));
        addressesModelList.add(new AddressesModel("abc Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",false));
        addressesModelList.add(new AddressesModel("xyz Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",false));
        addressesModelList.add(new AddressesModel("Dilip Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",false));
        addressesModelList.add(new AddressesModel("Dilip Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",false));
        addressesModelList.add(new AddressesModel("Dilip Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",false));
        addressesModelList.add(new AddressesModel("Dilip Patel", "57/555, udhsu, huedfhiuh, bdiagsi, dsauoh", "666113",false));

        int mode = getIntent().getIntExtra("MODE",-1);
        if (mode == SELECT_ADDRESS) {
            deliverHereBtn.setVisibility(View.VISIBLE);
        } else {
            deliverHereBtn.setVisibility(View.GONE);
        }

        addressesAdapter = new AddressesAdapter(addressesModelList, mode);
        myAddressesRecyclerview.setAdapter(addressesAdapter);
        ((SimpleItemAnimator)myAddressesRecyclerview.getItemAnimator()).setSupportsChangeAnimations(false);
        addressesAdapter.notifyDataSetChanged();
    }

    public static void refreshItem(int deselect, int select) {
        addressesAdapter.notifyItemChanged(deselect);
        addressesAdapter.notifyItemChanged(select);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}