package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;


import com.example.myapplication.data.ShoppingRepository;
import com.example.myapplication.model.api.JsonResponse;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ShoppingRepository shoppingRepository;
    private LiveData<List<JsonResponse>> jsonResponse;

    public MainViewModel(Application application) {
        super(application);
        shoppingRepository = new ShoppingRepository(application);
        jsonResponse = shoppingRepository.getJsonResponse();
    }


    LiveData<List<JsonResponse>> getJsonResponse() {
        return jsonResponse;
    }



    void saveJsonResponseList(JsonResponse jsonResponse) {
        shoppingRepository.insert(jsonResponse);
    }

//    public void synchronization(List<JsonResponse> jsonResponseList) {
//        //   shoppingRepository.synchronization(jsonResponseList);
//    }
//
//    public void updateOrCreate(JsonResponse jsonResponse) {
//       //   shoppingRepository.updateOrCreate(jsonResponse);
//    }


}
