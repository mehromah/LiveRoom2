package com.example.myapplication.data;



import com.example.myapplication.model.api.JsonResponse;

import java.util.List;

import io.reactivex.Flowable;

public interface ShoppingDataSource {
    Flowable<List<JsonResponse>> getJsonResponse();




}
