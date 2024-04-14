package com.lampro.lam_android_day8;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lampro.lam_android_day8.adapters.ProductAdapter;
import com.lampro.lam_android_day8.interfaces.IHomeView;
import com.lampro.lam_android_day8.object.dummy.AllProductResponse;
import com.lampro.lam_android_day8.object.dummy.Product;
import com.lampro.lam_android_day8.object.resful.Data;
import com.lampro.lam_android_day8.object.resful.ProductRequest;
import com.lampro.lam_android_day8.object.resful.ProductResponse;
import com.lampro.lam_android_day8.presenters.HomePersenter;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements IHomeView, ProductAdapter.IOnProductItemClickListener {

    private HomePersenter mHomePersenter;
    private RecyclerView rvProduct;
    private ProductAdapter mProductAdapter;
    private ArrayList<Product> mlistProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initView();
        intiData();
        getAllProduct();
    }

    private void intiData() {
        mHomePersenter = new HomePersenter(this);
        mlistProduct = new ArrayList<>();
        mProductAdapter = new ProductAdapter(mlistProduct);
        mProductAdapter.setCallback(this);
        rvProduct.setAdapter(mProductAdapter);
    }

    public void getAllProduct() {
        mHomePersenter.getAllProduct();
    }
    private void initView() {
        rvProduct = findViewById(R.id.rvProduct);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvProduct.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void getAllProductSuccess(AllProductResponse allProductResponse) {
        mlistProduct.clear();

        mProductAdapter.updateData((ArrayList<Product>) allProductResponse.getProducts());
    }

    @Override
    public void getAllProductError(String error) {

        Log.d(TAG, "getAllProductError: " +error);
    }

    @Override
    public void updateProductSuccess(ProductResponse response) {
        Log.d(TAG, "updateProductSuccess: " + response.toString());

    }

    @Override
    public void updateProductError(String error) {
        Log.d(TAG, "updateProductSuccess: " + error);

    }

    @Override
    public void onShopNowClick(Product product) {
        Toast.makeText(this,"" + product.getTitle(),Toast.LENGTH_SHORT).show();

        ProductRequest requestProduct = new ProductRequest();
        requestProduct.setName(product.getTitle());
        Data data = new Data();
        data.setYear(Calendar.getInstance().get(Calendar.YEAR));
        data.setCPUModel("Intel");
        data.setPrice(1900.0);
        data.setHardDiskSize("1 TB");
        requestProduct.setData(data);
        mHomePersenter.updateProduct(requestProduct);
    }

    @Override
    public void onFavorite(int position) {
        Product product = mlistProduct.get(position);
        product.setFavorite(product.isFavorite());
        mlistProduct.set(position, product);
        mProductAdapter.notifyDataSetChanged();
    }
}