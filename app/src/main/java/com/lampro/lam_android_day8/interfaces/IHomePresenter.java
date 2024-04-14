package com.lampro.lam_android_day8.interfaces;

import com.lampro.lam_android_day8.object.dummy.AllProductResponse;
import com.lampro.lam_android_day8.object.resful.ProductResponse;

public interface IHomePresenter {
    void getAllProductSuccess(AllProductResponse allProductResponse);

    void getAllProductError(String error);
    void updateProductSuccess(ProductResponse response);
    void updateProductError(String error);
}
