
package com.example.myapplication.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_PRSMBL005")
public class PRSMBL005 {
    @PrimaryKey
    @NonNull
    @SerializedName("CMBL003001")
    private String mCMBL003001;
    @SerializedName("CMBL005001")
    private String mCMBL005001;
    @SerializedName("NMBL005011")
    private String mNMBL005011;
    @SerializedName("NMBL005012")
    private String mNMBL005012;
    @SerializedName("NMBL005013")
    private String mNMBL005013;


    public PRSMBL005(String mNMBL005011){
        this.mNMBL005011 = mNMBL005011;
    }


    public String getCMBL003001() {
        return mCMBL003001;
    }

    public void setCMBL003001(String cMBL003001) {
        mCMBL003001 = cMBL003001;
    }

    public String getCMBL005001() {
        return mCMBL005001;
    }

    public void setCMBL005001(String cMBL005001) {
        mCMBL005001 = cMBL005001;
    }

    public String getNMBL005011() {
        return mNMBL005011;
    }

    public void setNMBL005011(String nMBL005011) {
        mNMBL005011 = nMBL005011;
    }

    public String getNMBL005012() {
        return mNMBL005012;
    }

    public void setNMBL005012(String nMBL005012) {
        mNMBL005012 = nMBL005012;
    }

    public String getNMBL005013() {
        return mNMBL005013;
    }

    public void setNMBL005013(String nMBL005013) {
        mNMBL005013 = nMBL005013;
    }

}
