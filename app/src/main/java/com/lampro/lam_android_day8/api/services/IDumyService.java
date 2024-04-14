package com.lampro.lam_android_day8.api.services;

import com.lampro.lam_android_day8.object.dummy.AllProductResponse;
import com.lampro.lam_android_day8.utils.Constant;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDumyService {
    @GET(Constant.GET_ALL_PRODUCT_API)
    Call<AllProductResponse> getAllProduct();
}
