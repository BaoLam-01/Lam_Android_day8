package com.lampro.lam_android_day8.interactors;

import com.lampro.lam_android_day8.api.ApiUtils;
import com.lampro.lam_android_day8.api.services.IApiRestfulServices;
import com.lampro.lam_android_day8.api.services.IDumyService;
import com.lampro.lam_android_day8.interfaces.IHomePresenter;
import com.lampro.lam_android_day8.object.dummy.AllProductResponse;
import com.lampro.lam_android_day8.object.resful.ProductRequest;
import com.lampro.lam_android_day8.object.resful.ProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractor {
    private IHomePresenter mHomePresenter;

    private IDumyService mDumyService;
    private IApiRestfulServices mIApiResfulServices;


    public HomeInteractor(IHomePresenter iHomePresenter) {
        this.mHomePresenter = iHomePresenter;
        mDumyService = ApiUtils.getDumyService();
        mIApiResfulServices = ApiUtils.getRestfulServices();
    }

    public void getAllProduct() {
        mDumyService.getAllProduct().enqueue(new Callback<AllProductResponse>() {
            @Override
            public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    if (mHomePresenter != null) {
                        mHomePresenter.getAllProductSuccess(response.body());
                    }
                } else {

                    if (mHomePresenter != null) {
                        mHomePresenter.getAllProductError(response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<AllProductResponse> call, Throwable throwable) {
                if (mHomePresenter != null) {
                    mHomePresenter.getAllProductError(throwable.getMessage());
                }
            }
        });
    }

    public void updateProduct(ProductRequest request) {
        mIApiResfulServices.updateProduct(request).enqueue(productResponseCallback);
    }
    private Callback<ProductResponse> productResponseCallback = new Callback<ProductResponse>() {
        @Override
        public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
            mHomePresenter.updateProductSuccess(response.body());
        }

        @Override
        public void onFailure(Call<ProductResponse> call, Throwable throwable) {
            mHomePresenter.updateProductError(throwable.getMessage());
        }
    };
}
