package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;


import com.example.myapplication.data.ShoppingRepository;
import com.example.myapplication.model.Product;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ShoppingRepository shoppingRepository;
    private LiveData<List<Product>> getProduct;

    public MainViewModel(Application application) {
        super(application);
        shoppingRepository = new ShoppingRepository(application);
        getProduct = shoppingRepository.getProduct();
    }


    LiveData<List<Product>> getJsonResponse() {
        return getProduct;
    }



    void saveJsonResponseList(Product product) {
        shoppingRepository.insert(product);
    }

    public void synchronization(List<Product> jsonResponseList) {
        //   shoppingRepository.synchronization(jsonResponseList);
    }

    public void updateOrCreate(Product jsonResponse) {
       //   shoppingRepository.updateOrCreate(jsonResponse);
    }


}
