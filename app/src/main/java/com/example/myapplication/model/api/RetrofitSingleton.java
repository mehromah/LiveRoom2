package com.example.myapplication.model.api;

import com.example.myapplication.data.ShoppingDataSource;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitSingleton implements ShoppingDataSource {
    protected Retrofit retrofit;

    public RetrofitSingleton() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://expertdevelopers.ir/api/v1/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
    }


}
