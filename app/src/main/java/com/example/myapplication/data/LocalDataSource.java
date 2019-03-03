package com.example.myapplication.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.myapplication.model.PRSMBL003;
import com.example.myapplication.model.PRSMBL004;
import com.example.myapplication.model.PRSMBL005;
import com.example.myapplication.model.api.JsonResponse;

import java.util.List;

import io.reactivex.Flowable;


@Dao
public abstract class LocalDataSource  {

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    public abstract void saveJsonResponseList(List<JsonResponse> jsonResponseList);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL003List(List<PRSMBL003> prsmbl003s);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL004List(List<PRSMBL004> prsmbl004s);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void savePRSMBL005List(List<PRSMBL005> prsmbl005s);




    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void saveJsonResponseList(List<PRSMBL003> prsmbl003s, List<PRSMBL004> prsmbl004s, List<PRSMBL005> prsmbl005s);

//    @Update
//    public abstract void update(List<JsonResponse> jsonResponses);

    @Query("SELECT * FROM tbl_PRSMBL003,tbl_PRSMBL004,tbl_PRSMBL005")
    Flowable<List<JsonResponse>> getJsonResponse(){
        return null;
    }

//    @Query("DELETE FROM tbl_prsmbl003,tbl_PRSMBL004,tbl_PRSMBL005")
//    public abstract void removeAllRows();


}
