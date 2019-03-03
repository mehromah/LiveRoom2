
package com.example.myapplication.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_PRSMBL004")
public class PRSMBL004 {
    @PrimaryKey
    @NonNull
    @SerializedName("CMBL003001")
    private String mCMBL003001;
    @SerializedName("CMBL004001")
    private String mCMBL004001;
    @SerializedName("CMBL004011")
    private String mCMBL004011;
    @SerializedName("CMBL004012")
    private String mCMBL004012;
    @SerializedName("CMBL004014")
    private String mCMBL004014;
    @SerializedName("NMBL004013")
    private String mNMBL004013;


    public PRSMBL004(String mCMBL004012){
        this.mCMBL004012 = mCMBL004012;
    }



    public String getCMBL003001() {
        return mCMBL003001;
    }

    public void setCMBL003001(String cMBL003001) {
        mCMBL003001 = cMBL003001;
    }

    public String getCMBL004001() {
        return mCMBL004001;
    }

    public void setCMBL004001(String cMBL004001) {
        mCMBL004001 = cMBL004001;
    }

    public String getCMBL004011() {
        return mCMBL004011;
    }

    public void setCMBL004011(String cMBL004011) {
        mCMBL004011 = cMBL004011;
    }

    public String getCMBL004012() {
        return mCMBL004012;
    }

    public void setCMBL004012(String cMBL004012) {
        mCMBL004012 = cMBL004012;
    }

    public String getCMBL004014() {
        return mCMBL004014;
    }

    public void setCMBL004014(String cMBL004014) {
        mCMBL004014 = cMBL004014;
    }

    public String getNMBL004013() {
        return mNMBL004013;
    }

    public void setNMBL004013(String nMBL004013) {
        mNMBL004013 = nMBL004013;
    }

}
