package com.lampro.lam_android_day8.api;

import com.lampro.lam_android_day8.api.services.IApiRestfulServices;
import com.lampro.lam_android_day8.api.services.IDumyService;

public class ApiUtils {
    public static IDumyService getDumyService() {
        return RetrofitClient.getInstances().create(IDumyService.class);
    }

    public static IApiRestfulServices getRestfulServices() {
        return DemoRetrofitClient.getInstances().create(IApiRestfulServices.class);
    }

}
