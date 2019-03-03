package com.example.myapplication.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.example.myapplication.model.PRSMBL003;
import com.example.myapplication.model.PRSMBL004;
import com.example.myapplication.model.PRSMBL005;


@Database(entities = {PRSMBL003.class, PRSMBL004.class, PRSMBL005.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LocalDataSource getLocalDataSource();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "shopping_db")
                    .build();
        }
        return instance;
    }
}
