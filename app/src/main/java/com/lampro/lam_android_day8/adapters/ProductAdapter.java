package com.lampro.lam_android_day8.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lampro.lam_android_day8.R;
import com.lampro.lam_android_day8.object.dummy.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    ArrayList<Product> mListProduct;
    private Context mcontext;
    IOnProductItemClickListener callback;

    public ProductAdapter(ArrayList<Product> mListProduct) {
        this.mListProduct = mListProduct;
    }

    public void setCallback(IOnProductItemClickListener callback) {
        this.callback = callback;
    }

    public void updateData(ArrayList<Product> listProduct) {
        this.mListProduct.addAll(listProduct);
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext =parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product product = mListProduct.get(position);
        holder.tvProductName.setText(product.getTitle());
        Glide.with(mcontext).load(product.getThumbnail()).into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return mListProduct != null ? mListProduct.size() : 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgProduct, imgFavorite;
        TextView tvProductName;
        LinearLayout llShopNow;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            imgFavorite = itemView.findViewById(R.id.imgFavorite);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            llShopNow = itemView.findViewById(R.id.llShopNow);

            llShopNow.setOnClickListener(this);
            imgFavorite.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (callback != null) {
                if (v.getId() == R.id.llShopNow) {
                    Product product = mListProduct.get(getAdapterPosition());
                    callback.onShopNowClick(product);
                }
                if (v.getId() == R.id.imgFavorite) {
                    callback.onFavorite(getAdapterPosition());
                }
            }

        }
    }

    public interface IOnProductItemClickListener {
        void onShopNowClick(Product product);

        void onFavorite(int position);
    }
}
