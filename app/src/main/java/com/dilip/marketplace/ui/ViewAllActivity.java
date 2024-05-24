package com.dilip.marketplace.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.ActivityViewAllBinding;
import com.dilip.marketplace.ui.grid_product_view.GridProductLayoutAdapter;
import com.dilip.marketplace.ui.horizontal_product_view.HorizontalProductScrollModel;
import com.dilip.marketplace.ui.wishlist.WishlistAdapter;
import com.dilip.marketplace.ui.wishlist.WishlistModel;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {

    ActivityViewAllBinding binding;
    private RecyclerView recyclerView;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewAllBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the Day");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = binding.recyclerview;
        gridView = binding.gridView;

        int layout_code = getIntent().getIntExtra("layout_code",-1);

        if (layout_code == 0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishlistModel> wishlistModelList = new ArrayList<>();
            wishlistModelList.add(new WishlistModel(R.drawable.iphone_13, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.galaxy_m34, "Iphone 13 (Black, 128 GB)", 0, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.realme_13c, "Iphone 13 (Black, 128 GB)", 4, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.oneplus_nord, "Iphone 13 (Black, 128 GB)", 2, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.oneplus_11r, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.iphone_13, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.galaxy_m34, "Iphone 13 (Black, 128 GB)", 0, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.realme_13c, "Iphone 13 (Black, 128 GB)", 4, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.oneplus_nord, "Iphone 13 (Black, 128 GB)", 2, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.oneplus_11r, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.iphone_13, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.galaxy_m34, "Iphone 13 (Black, 128 GB)", 0, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.realme_13c, "Iphone 13 (Black, 128 GB)", 4, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.oneplus_nord, "Iphone 13 (Black, 128 GB)", 2, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));
            wishlistModelList.add(new WishlistModel(R.drawable.oneplus_11r, "Iphone 13 (Black, 128 GB)", 1, "3", 222, "Rs.99,999/-", "Rs.1,99,999/-", "Cash on delivery"));

            WishlistAdapter adapter = new WishlistAdapter(wishlistModelList,false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();


        } else if (layout_code == 1) {
            gridView.setVisibility(View.VISIBLE);

            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iqoo_z6,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_nord,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_11r,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.galaxy_m34,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.oneplus_11r,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.galaxy_m34,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));
            horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.iphone_13,"I Phone 13","Bionic A2", "Rs.99,999"));


            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProductScrollModelList);
            gridView.setAdapter(gridProductLayoutAdapter);
            gridProductLayoutAdapter.notifyDataSetChanged();
        }


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