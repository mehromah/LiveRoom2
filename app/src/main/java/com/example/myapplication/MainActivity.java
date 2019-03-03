package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.myapplication.model.Product;
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
        viewModel.getJsonResponse().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable final List<Product> jsonResponses) {
                productAdapter.setProducts(jsonResponses);
            }
        });
    }


    private void setupViews() {




    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getCoordinatorLayoutId() {
        return R.id.coordinator_main;
    }
}
