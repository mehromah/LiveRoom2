package com.example.myapplication;


import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;



public abstract class BaseActivity extends AppCompatActivity {
    public abstract int getCoordinatorLayoutId();

    public void showSnackBarMessage(String message) {
        Snackbar.make(findViewById(getCoordinatorLayoutId()),
                message, Snackbar.LENGTH_SHORT).show();
    }


}
