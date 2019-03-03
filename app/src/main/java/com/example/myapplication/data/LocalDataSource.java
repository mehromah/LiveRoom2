package com.example.myapplication.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.myapplication.model.Product;

import java.util.List;

import io.reactivex.Flowable;


@Dao
public abstract class LocalDataSource  {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void saveProductList(List<Product> productList);

    @Update
    public abstract void update(List<Product> productList);

    @Query("SELECT * FROM tbl_product")
    LiveData<List<Product>> getProduct(){
        return null;
    }

    @Query("DELETE FROM tbl_product")
    public abstract void removeAllRows();


}
