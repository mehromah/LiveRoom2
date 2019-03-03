package com.example.myapplication.model.api;


import android.arch.lifecycle.LiveData;

import com.example.myapplication.model.Product;

import java.util.List;
import java.util.Observable;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface ApiService {

    @GET("product/list")
    Flowable<List<Product>> getProducts() ;

}
