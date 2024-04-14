package com.lampro.lam_android_day8.presenters;

import com.lampro.lam_android_day8.interactors.HomeInteractor;
import com.lampro.lam_android_day8.interfaces.IHomePresenter;
import com.lampro.lam_android_day8.interfaces.IHomeView;
import com.lampro.lam_android_day8.object.dummy.AllProductResponse;
import com.lampro.lam_android_day8.object.resful.ProductRequest;
import com.lampro.lam_android_day8.object.resful.ProductResponse;

public class HomePersenter implements IHomePresenter {

    private IHomeView mHomeView;
    private HomeInteractor mhomeInteractor;

    public HomePersenter(IHomeView iHomeView) {
        this.mHomeView = iHomeView;
        mhomeInteractor = new HomeInteractor(this);
    }

    public void getAllProduct() {
        mhomeInteractor.getAllProduct();
    }
    public void updateProduct(ProductRequest request) {
        mhomeInteractor.updateProduct(request);
    }
    @Override
    public void getAllProductSuccess(AllProductResponse response) {
        if (mHomeView != null) {
            mHomeView.getAllProductSuccess(response);
        }

    }

    @Override
    public void getAllProductError(String error) {
        if (mHomeView != null) {
            mHomeView.getAllProductError(error);
        }

    }

    @Override
    public void updateProductSuccess(ProductResponse response) {
        if (mHomeView != null) {
            mHomeView.updateProductSuccess(response);
        }
    }

    @Override
    public void updateProductError(String error) {
        if (mHomeView != null) {
            mHomeView.updateProductError(error);
        }

    }



}
