package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myapplication.model.api.JsonResponse;
import com.example.myapplication.slider.MainSliderAdapter;
import com.example.myapplication.slider.PicassoImageLoadingService;

import java.util.List;

import ss.com.bannerslider.Slider;

public class MainActivity extends BaseActivity  implements View.OnClickListener  {
    private MainViewModel viewModel;
    private RecyclerView prsmbl003RecyclerView;
    private RecyclerView productRecyclerView;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getJsonResponse().observe(this, new Observer<List<JsonResponse>>() {
            @Override
            public void onChanged(@Nullable final List<JsonResponse> jsonResponses) {
                productAdapter.setProduct(jsonResponses);
            }
        });
    }


    private void setupViews() {
        Slider.init(new PicassoImageLoadingService(this));

        Slider slider = findViewById(R.id.banner_slider1);
        slider.setAdapter(new MainSliderAdapter());









        productRecyclerView = findViewById(R.id.rv_main_popularProducts);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, true
        ));
        productAdapter = new ProductAdapter(this);
        productRecyclerView.setAdapter(productAdapter);


        prsmbl003RecyclerView = findViewById(R.id.rv_main_latestProducts);
        prsmbl003RecyclerView.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, true
        ));
        productAdapter = new ProductAdapter(this);
        productRecyclerView.setAdapter(productAdapter);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getCoordinatorLayoutId() {
        return R.id.coordinator_main;
    }
}
