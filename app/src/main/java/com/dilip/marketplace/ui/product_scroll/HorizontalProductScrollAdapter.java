package com.dilip.marketplace.ui.product_scroll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dilip.marketplace.R;
import com.dilip.marketplace.databinding.HorizontalScrollItemBinding;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {

    private List<HorizontalProductScrollModel> horizontalProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModel> horizontalProductScrollModelList) {
        this.horizontalProductScrollModelList = horizontalProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder holder, int position) {
        int resource = horizontalProductScrollModelList.get(position).getProductImage();
        String title = horizontalProductScrollModelList.get(position).getProductTitle();
        String description = horizontalProductScrollModelList.get(position).getProductDescription();
        String price = horizontalProductScrollModelList.get(position).getProductPrice();

        holder.setProductImage(resource);
        holder.setProductTitle(title);
        holder.setProductDescription(description);
        holder.setProductPrice(price);
    }

    @Override
    public int getItemCount() {
        return horizontalProductScrollModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        HorizontalScrollItemBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = HorizontalScrollItemBinding.bind(itemView);
        }

        private void setProductImage(int resource) {
            binding.productImage.setImageResource(resource);
        }

        private void setProductTitle(String title) {
            binding.productTitle.setText(title);
        }

        private void setProductDescription(String description) {
            binding.productDiscription.setText(description);
        }

        private void setProductPrice(String price) {
            binding.productPrice.setText(price);
        }
    }
}
