package com.example.myapplication.model;

import android.arch.lifecycle.LiveData;

import com.example.myapplication.model.api.ApiService;
import com.example.myapplication.model.api.RetrofitSingleton;

import java.util.List;


public class MainCloudDataSource extends RetrofitSingleton {
    private ApiService apiService;
    public MainCloudDataSource() {
        super();
        apiService = retrofit.create(ApiService.class);

    }


    @Override
    public LiveData<List<Product>> getProduct() {
        return null;
    }
}
