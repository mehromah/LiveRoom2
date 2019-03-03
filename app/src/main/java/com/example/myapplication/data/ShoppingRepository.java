package com.example.myapplication.data;

import android.annotation.TargetApi;
import android.app.Application;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import com.example.myapplication.model.MainCloudDataSource;
import com.example.myapplication.model.Product;
import com.example.myapplication.model.api.RetrofitSingleton;

import org.reactivestreams.Subscription;

import java.util.Collections;
import java.util.List;


import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ShoppingRepository implements ShoppingDataSource {
    private RetrofitSingleton cloudDataSource;
    private  LocalDataSource localDataSource;
    private LiveData<List<Product>> getProduct;



    public ShoppingRepository(Application application) {
        localDataSource = AppDatabase.getInstance(application).getLocalDataSource();
        cloudDataSource = new MainCloudDataSource();
        getProduct = localDataSource.getProduct();

    }

    public LiveData<List<Product>> getProductList() {

        cloudDataSource.getProduct().subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new FlowableSubscriber<List<Product>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);

            }

            @Override
            public void onNext(List<Product> productList) {
                localDataSource.saveProductList(productList);
            }



            @Override
            public void onError(Throwable t) {
                Log.e("ShoppingRepo", "onError: " + t.toString());

            }

            @Override
            public void onComplete() {

            }
        });

        return localDataSource.getProduct();
    }


    public LiveData<List<Product>> getProduct() {
        return getProduct;
    }



    public void insert(Product product) {
        new insertAsyncTask(localDataSource).execute((Runnable) product);
    }




    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    private static class insertAsyncTask extends AsyncTask<Product, Void, Void> {

        private LocalDataSource mAsyncTaskDao;
        private Product[] params;

        insertAsyncTask(LocalDataSource dao) {
            mAsyncTaskDao = dao;
        }



        @Override
        protected Void doInBackground(final Product... params) {
            this.params = params;
            mAsyncTaskDao.saveProductList(Collections.singletonList(params[0]));
            return null;
        }


    }





}
