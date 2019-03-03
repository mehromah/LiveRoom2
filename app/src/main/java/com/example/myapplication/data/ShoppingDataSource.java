package com.example.myapplication.data;



import android.arch.lifecycle.LiveData;

import com.example.myapplication.model.Product;

import java.util.List;

public interface ShoppingDataSource {
    LiveData<List<Product>> getProduct();




}
