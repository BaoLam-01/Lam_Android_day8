package com.lampro.lam_android_day8.api.services;

import com.lampro.lam_android_day8.object.dummy.AllProductResponse;
import com.lampro.lam_android_day8.object.resful.ProductRequest;
import com.lampro.lam_android_day8.object.resful.ProductResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IApiRestfulServices {
    @POST("objects")
    Call<ProductResponse> updateProduct(@Body ProductRequest request);
}
