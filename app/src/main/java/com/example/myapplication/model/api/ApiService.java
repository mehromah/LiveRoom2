package com.example.myapplication.model.api;

import android.arch.lifecycle.LiveData;

import java.util.List;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/values?url=<NewDataSet><Table><ver>1_02.01.06</ver><proc>001LOCALSELECT</proc><P1>010001</P1><P2></P2><P3></P3><P4>1</P4></Table></NewDataSet>")
    LiveData<List<JsonResponse>> getJSON();




}
