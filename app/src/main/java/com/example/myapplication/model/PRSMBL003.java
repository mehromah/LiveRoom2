
package com.example.myapplication.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_PRSMBL003")
public class PRSMBL003 {
    @PrimaryKey
    @NonNull
    @SerializedName("CMBL003001")
    private String mCMBL003001;
    @SerializedName("CMBL003010")
    private String mCMBL003010;
    @SerializedName("CMBL003011")
    private String mCMBL003011;
    @SerializedName("CMBL003014")
    private String mCMBL003014;
    @SerializedName("CMBL003016")
    private String mCMBL003016;
    @SerializedName("CMBL003017")
    private String mCMBL003017;
    @SerializedName("NMBL003012")
    private String mNMBL003012;
    @SerializedName("NMBL003015")
    private String mNMBL003015;


    public PRSMBL003(String mCMBL003010,String mCMBL003011,String mNMBL003015,String mCMBL003016){
        this.mCMBL003010 = mCMBL003010;
        this.mCMBL003011 = mCMBL003011;
        this.mNMBL003015 = mNMBL003015;
        this.mCMBL003016 = mCMBL003016;
    }


    public String getCMBL003001() {
        return mCMBL003001;
    }

    public void setCMBL003001(String cMBL003001) {
        mCMBL003001 = cMBL003001;
    }

    public String getCMBL003010() {
        return mCMBL003010;
    }

    public void setCMBL003010(String cMBL003010) {
        mCMBL003010 = cMBL003010;
    }

    public String getCMBL003011() {
        return mCMBL003011;
    }

    public void setCMBL003011(String cMBL003011) {
        mCMBL003011 = cMBL003011;
    }

    public String getCMBL003014() {
        return mCMBL003014;
    }

    public void setCMBL003014(String cMBL003014) {
        mCMBL003014 = cMBL003014;
    }

    public String getCMBL003016() {
        return mCMBL003016;
    }

    public void setCMBL003016(String cMBL003016) {
        mCMBL003016 = cMBL003016;
    }

    public String getCMBL003017() {
        return mCMBL003017;
    }

    public void setCMBL003017(String cMBL003017) {
        mCMBL003017 = cMBL003017;
    }

    public String getNMBL003012() {
        return mNMBL003012;
    }

    public void setNMBL003012(String nMBL003012) {
        mNMBL003012 = nMBL003012;
    }

    public String getNMBL003015() {
        return mNMBL003015;
    }

    public void setNMBL003015(String nMBL003015) {
        mNMBL003015 = nMBL003015;
    }

}
