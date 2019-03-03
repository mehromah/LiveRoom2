package com.example.myapplication.data;

import android.annotation.TargetApi;
import android.app.Application;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import com.example.myapplication.model.MainCloudDataSource;
import com.example.myapplication.model.PRSMBL003;
import com.example.myapplication.model.PRSMBL004;
import com.example.myapplication.model.PRSMBL005;
import com.example.myapplication.model.api.JsonResponse;
import com.example.myapplication.model.api.RetrofitSingleton;

import org.reactivestreams.Subscription;

import java.util.Collections;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ShoppingRepository implements ShoppingDataSource {
    private RetrofitSingleton cloudDataSource;
    private  LocalDataSource localDataSource;
    private LiveData<List<com.example.myapplication.model.api.JsonResponse>> JsonResponse;


    public ShoppingRepository(Application application) {
        localDataSource = AppDatabase.getInstance(application).getLocalDataSource();
        cloudDataSource = new MainCloudDataSource();
        JsonResponse = localDataSource.getJsonResponse();

    }

    @Override
    public Flowable<List<JsonResponse>> getJsonResponse() {
        cloudDataSource.getJsonResponse().subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new FlowableSubscriber<List<JsonResponse>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);

            }

            @Override
            public void onNext(List<com.example.myapplication.model.api.JsonResponse> jsonResponses) {
                    localDataSource.saveJsonResponseList(jsonResponses);
            }

            @Override
            public void onError(Throwable t) {
                Log.e("ShoppingRepo", "onError: " + t.toString());

            }

            @Override
            public void onComplete() {

            }
        });

        return localDataSource.getJsonResponse();
    }


    LiveData<List<JsonResponse>> getGetJsonResponse() {
        return JsonResponse;
    }



    public void insert(JsonResponse jsonResponse) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            new insertAsyncTask(localDataSource).execute(jsonResponse);
        }
    }


    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    private static class insertAsyncTask extends AsyncTask<JsonResponse, Void, Void> {

        private LocalDataSource mAsyncTaskDao;

        insertAsyncTask(LocalDataSource dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final JsonResponse... params) {
            mAsyncTaskDao.saveJsonResponseList(Collections.singletonList(params[0]));
            return null;
        }
    }





}
